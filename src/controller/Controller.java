package controller;
import model.Mundo;
import processing.core.PApplet;

public class Controller {
	private PApplet app;
	private Mundo mundo;
	
	public Controller(PApplet app) {
		this.app = app;
		mundo = new Mundo(app);
	}
	public void draw() {
		mundo.draw();
	}
	public void mouseClicked() {
		mundo.mouseClicked();
	}
}
