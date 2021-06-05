package model;

import processing.core.PApplet;

public class Mundo {
PApplet app;
MarcoFox fox;
public Mundo(PApplet app) {
	this.app = app;
	fox = new MarcoFox(350,350,1,app,255,0,0);
}
public void draw() {
	fox.draw();
	fox.move();
}
public void mouseClicked() {
	fox.moveSetup(app.mouseX, app.mouseY);
}
}
