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
	tux.draw();
	fox.move();
	tux.move();
	fox.speak();
	tux.speak();
}
public void mouseClicked() {
	fox.moveSetup(app.mouseX, app.mouseY);
}
}
