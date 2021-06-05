package model;

import processing.core.PApplet;

public abstract class Automata implements Runnable{
	
protected float dirX,dirY,posX,posY;
protected int spd,size,color;
PApplet app;

public Automata(float posX, float posY, int spd, PApplet app) {
	this.app = app;
	this.posX = posX;
	this.posY = posY;
	this.spd = spd;
	dirX = 1;
	dirY = 1;
	size=20;
	color=255;
}
public abstract void draw();
public abstract void move();
public abstract void speak();
}

