package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Mundo {
PApplet app;
ArrayList<MarcoFox> marquitos;
ArrayList<PoloTux> politos;
MarcoFox fox;
PoloTux tux;
public Mundo(PApplet app) {
	this.app = app;
	
	
	marquitos = new ArrayList<MarcoFox>();
	politos = new ArrayList<PoloTux>();
	marquitos.add(new MarcoFox(525,350,2,app,0,199,255));
	for (int i = 0; i < 20; i++) {
		float posx = app.random(10,350);
		float posy = app.random(10,700);
	politos.add(new PoloTux(posx,posy,1,app,255,173,0));
	}
}
public void draw() {
	for (MarcoFox marquito : marquitos) {
		marquito.draw();
		marquito.move();
		new Thread(marquito).start();
	}
	for (PoloTux polito : politos) {
		polito.draw();
		polito.move();
		new Thread(polito).start();
	}
	//Función para comer polos
	float maxDist = 700;
	float closeDist = 0;
	int politoPursued=0;
for (int i = 0; i < politos.size(); i++) {
	politos.get(politoPursued).setPursued(false);
		closeDist =PApplet.dist(marquitos.get(0).getPosX(),marquitos.get(0).getPosY(),
				                 politos.get(i).getPosX(),politos.get(i).getPosY());
		if(closeDist<maxDist) {
			maxDist=closeDist;
			politoPursued=i;
		}
	}
	politos.get(politoPursued).setPursued(true);
	marquitos.get(0).moveSetup(politos.get(politoPursued).getPosX(),politos.get(politoPursued).getPosY());
	if(PApplet.dist(marquitos.get(0).getPosX(), marquitos.get(0).getPosY(), 
			politos.get(politoPursued).getPosX(), politos.get(politoPursued).getPosY()) < 20) {
		marquitos.remove(0);
		marquitos.add(new MarcoFox(politos.get(politoPursued).getPosX(), politos.get(politoPursued).getPosY(),
				2,app,0,199,255));
		politos.remove(politoPursued);
		
		
	}
	//Para que el programa no se dañe al final
	try {
        PoloTux element = politos.get(politos.size()-1);
        
     } catch(ArrayIndexOutOfBoundsException e) {
    	 app.fill(255,0,0);
    	 app.textSize(50);
        app.text("Game Over",(app.width/2)-150,(app.height/2));
     }
}

public void mouseClicked() {
	
	}
	
	

}
;