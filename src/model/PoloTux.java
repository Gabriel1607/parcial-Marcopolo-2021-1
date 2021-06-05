package model;

import processing.core.PApplet;

public class PoloTux extends Automata {
private boolean isPursued;
private boolean amague;
	public PoloTux(float posX, float posY, int spd, PApplet app, int r, int g, int b) {
		super(posX, posY, spd, app, r, g, b);
		isPursued= false;
	}

	public boolean isPursued() {
		return isPursued;
	}

	public void setPursued(boolean isPursued) {
		this.isPursued = isPursued;
	}


	public void run() {
		
		
		try {
			Thread.sleep(2000);
			//speak();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void draw() {
		System.out.println(spd);
		app.fill(r, g, b);
		app.circle(posX, posY, size);
		if(PApplet.second()%2==0) {
			app.fill(0);
			app.text("¡Polo! ("+(int)posX+","+(int)posY+")", posX-size-15, posY+size);
			}
	}

	@Override
	protected void move() {
		if(isPursued) {
			if(PApplet.second()%3==0) {
			amague = true;
			}
			
			if(amague) {
				spd=3;
				dirY=-dirY;
			}
			if(PApplet.second()%3!=0) {
			amague = false;
			spd=1;
		}
		}
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
	public void speak() {
		
		if(PApplet.second()%2==0) {
			System.out.println("¡Polo!");
			}
	
		
		
	}

}
