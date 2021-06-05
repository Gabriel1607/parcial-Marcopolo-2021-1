package model;

import processing.core.PApplet;

public abstract class Automata implements Runnable{
	
protected float dirX,dirY,posX,posY;
protected int spd,size,r,g,b;
PApplet app;

public Automata(float posX, float posY, int spd, PApplet app, int r,int g,int b) {
	this.app = app;
	this.posX = posX;
	this.posY = posY;
	this.spd = spd;
	this.r = r;
	this.g =g;
	this.b = b;
	dirX = 1;
	dirY = 1;
	size=20;
	
}
public abstract void draw();
public abstract void move();
public abstract void speak();
}

