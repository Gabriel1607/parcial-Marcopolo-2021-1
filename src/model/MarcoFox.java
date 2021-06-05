package model;

import processing.core.PApplet;

public class MarcoFox extends Automata {

	public MarcoFox(float posX, float posY, int spd, PApplet app, int r,int g,int b) {
		super(posX, posY, spd, app,r,g,b);
	}

	@Override
	public void run() {
		move();
		speak();
		try {
			Thread.sleep(2000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void draw() {
		app.fill(r, g, b);
		app.circle(posX, posY, size);
		
	}

	
	public void moveSetup(float poloX, float poloY) {
		//Diferencia de Vectores
		dirX=poloX-this.posX;
		dirY=poloY-this.posY;
		//Normalizar el vector para que valga 1 o -1
		float dist = (float) Math.sqrt(dirX * dirX + dirY * dirY); 
		if(dist != 0.0) {
			dirX /= dist;
			dirY /= dist;
		}
		
		
	}
	
	@Override
	public void move() {
		// TODO Auto-generated method stub
		posX+=dirX*spd;
		posY+=dirY*spd;
	}
	@Override
	public void speak() {
		// TODO Auto-generated method stub
		app.text("Marco", posX, posY+size);
		
	}

	

}
