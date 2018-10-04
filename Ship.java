package asteroids;

import java.awt.event.KeyEvent;

public class Ship extends Polygon {

	private boolean forward = false, left = false, right = false;
	private Point position;
	private Point[] pts;
	
	/*
	 * This constructor created a new ship with an array of points
	 */
	public Ship(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		position = inPosition;
		
		pts = inShape;

	}

	//These 4 methods move the ship at certain rates
	public void moveRight(boolean right) {

		if (right) {
			position.setX(position.getX() + 10);
		}
	}

	public void moveLeft(boolean left) {

		if (left) {
			position.setX(position.getX() - 10);
		}
	}

	public void moveUp(boolean up) {

		if (up) {
			position.setY(position.getY() - 10);
		}
	}

	public void moveDown(boolean down) {

		if (down) {
			position.setY(position.getY() + 10);
		}
	}
	
	public int getX(){
		return (int) position.getX();
	}
	
	public int getY(){
		return (int) position.getY();    
	}

	
}