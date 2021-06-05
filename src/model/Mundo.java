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

	
	//System.out.println(fox.getSpd());
}
public void mouseClicked() {
	for (MarcoFox marcoFox : marquitos) {
		marcoFox.moveSetup(app.mouseX, app.mouseY);
	}
	
	
}
}
