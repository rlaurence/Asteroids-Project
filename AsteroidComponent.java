package asteroids;


import java.awt.*;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class AsteroidComponent extends Polygon{
	
	private Point position;
	
	/*
	 * This constructor creates an array of asteroids to be used in the game
	 */
	 public AsteroidComponent(Point[] inShape, Point inPosition, double inRotation) {
	       super(inShape, inPosition, inRotation);
	       position = inPosition;
	   
	   }
	 
	 /*
	  * This method moves the asteroids at a certain speed and then resets them at the top
	  * @speed the speed at which the asteroids move
	  */
	 public void move(double speed){
		 if(position.getY() < 800){
			 position.setY(position.getY() + speed); 
		 }
		 if(position.getY() == 800){
			 position.setY(0);
		 } 
	 }
	 
	 public int getX(){
		 return (int) position.getX();
	 }
	 
	 public int getY(){
		 return(int) position.getY();
	 }
	
	 //resets the asteroid to the top if a collision occurs
	 public void destroyAst(){
		 position.setY(0);
		 position.setX((int) (Math.random() * 980) + 10);
	 }
	
	
	
	
	
}
