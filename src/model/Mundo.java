package model;

import processing.core.PApplet;

public class Mundo {
PApplet app;
MarcoFox fox;
PoloTux tux;
public Mundo(PApplet app) {
	this.app = app;
	fox = new MarcoFox(350,350,2,app,255,0,0);
	tux = new PoloTux(1,1,1,app,0,255,0);
}
public void draw() {
	fox.draw();
	//fox.move();
	new Thread(fox).start();
	//tux.draw();
	//tux.move();
	//tux.speak();
	//System.out.println(fox.getCounter());
}
public void mouseClicked() {
	fox.moveSetup(app.mouseX, app.mouseY);
}
}
