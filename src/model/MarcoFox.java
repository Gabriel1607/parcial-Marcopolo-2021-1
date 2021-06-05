package model;

import processing.core.PApplet;

public class MarcoFox extends Automata implements Runnable {
	public MarcoFox(float posX, float posY, int spd, PApplet app, int r,int g,int b) {
		super(posX, posY, spd, app,r,g,b);
	}

	@Override
	public void run() {
		// while (true) {
			 
		try {
			
			Thread.sleep(2000);
			//speak();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}
	//}
	@Override
	public void draw() {
		app.fill(r, g, b);
		app.circle(posX, posY, size);
		if(PApplet.second()%2==0) {
		app.fill(0);
		app.text("¡Marco!", posX-size, posY+size+1);
		}
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
	protected void move() {
		
		posX+=dirX*spd;
		posY+=dirY*spd;
		if(posX>app.width||0>posX) {
			dirX=-dirX;
		}
		if(posY>app.height||0>posY) {
			dirY=-dirY;
		}
	}
	@Override
	protected void speak() {
		//
		if(PApplet.second()%2==0) {
		System.out.println("Marco");
		}
	
	}

	

}
