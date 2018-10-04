package asteroids;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyListener;

public class AsteroidsGame extends Game implements KeyListener {
	KeyEvent e;
	private int counter = 0;
	private int shots = 0;
	private int lives = 10;
	private double speed = 2.5;
	private int score = 0;
	private boolean SPC = false;
	private boolean running = true;
	public int[] xCoords = { 600, 595, 605 };
	public int[] yCoords = { 600, 615, 615 };

	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;

	private Ship ship;
	private AsteroidComponent asteroid;
	private AsteroidComponent asteroid2;
	private AsteroidComponent asteroid3;
	private AsteroidComponent asteroid4;
	private AsteroidComponent asteroid5;
	private AsteroidComponent asteroid6;
	
	
	private Point shipLoc;
	private Point bulLoc;
	
	
	BulletComponent[] buls = new BulletComponent[10000];
	
	//This method runs the whole game
	public AsteroidsGame() {
		//This titles the frame
		super("Asteroids!", 1000, 800);
		this.setFocusable(true);
		this.requestFocus();
		addKeyListener(this);

		// creates points for each asteroid
		int astX = (int) (Math.random() * 166) + 5;
		int astX2 = (int) (Math.random() * 166) + 166;
		int astX3 = (int) (Math.random() * 166) + 332;
		int astX4 = (int) (Math.random() * 166) + 498;
		int astX5 = (int) (Math.random() * 166) + 664;
		int astX6 = (int) (Math.random() * 166) + 820; 		
		//first asteroid
		Point astP1 = new Point(astX, 0);
		Point astP2 = new Point(astX - 10, 10);
		Point astP3 = new Point(astX, 20);
		Point astP4 = new Point(astX + 10, 20);
		Point astP5 = new Point(astX + 20, 10);
		Point astP6 = new Point(astX + 10, 0);

		//second asteroid
		Point ast2P1 = new Point(astX2, 0);
		Point ast2P2 = new Point(astX2 - 10, 10);
		Point ast2P3 = new Point(astX2, 20);
		Point ast2P4 = new Point(astX2 + 10, 20);
		Point ast2P5 = new Point(astX2 + 20, 10);
		Point ast2P6 = new Point(astX2 + 10, 0);

		//third asteroid
		Point ast3P1 = new Point(astX3, 0);
		Point ast3P2 = new Point(astX3 - 10, 10);
		Point ast3P3 = new Point(astX3, 20);
		Point ast3P4 = new Point(astX3 + 10, 20);
		Point ast3P5 = new Point(astX3 + 20, 10);
		Point ast3P6 = new Point(astX3 + 10, 0);
		
		//fourth asteroid
		Point ast4P1 = new Point(astX4, 0);
		Point ast4P2 = new Point(astX4 - 10, 10);
		Point ast4P3 = new Point(astX4, 20);
		Point ast4P4 = new Point(astX4 + 10, 20);
		Point ast4P5 = new Point(astX4 + 20, 10);
		Point ast4P6 = new Point(astX4 + 10, 0);
		
		//fifth asteroid
		Point ast5P1 = new Point(astX5, 0);
		Point ast5P2 = new Point(astX5 - 10, 10);
		Point ast5P3 = new Point(astX5, 20);
		Point ast5P4 = new Point(astX5 + 10, 20);
		Point ast5P5 = new Point(astX5 + 20, 10);
		Point ast5P6 = new Point(astX5 + 10, 0);
		
		//sixth asteroid
		Point ast6P1 = new Point(astX6, 0);
		Point ast6P2 = new Point(astX6 - 10, 10);
		Point ast6P3 = new Point(astX6, 20);
		Point ast6P4 = new Point(astX6 + 10, 20);
		Point ast6P5 = new Point(astX6 + 20, 10);
		Point ast6P6 = new Point(astX6 + 10, 0);

		//these points create the ship and where the asteroids will start
		Point p1 = new Point(600, 600);
		Point p2 = new Point(595, 615);
		Point p3 = new Point(605, 615);
		Point center = new Point(astX, 0);
		Point center2 = new Point(astX2, 0);
		Point center3 = new Point(astX3, 0);
		Point center4 = new Point(astX4, 0);
		Point center5 = new Point(astX4, 0);
		Point center6 = new Point(astX4, 0);
		
		
		Point[] a = { p1, p2, p3 };
		Point[] pA = { astP1, astP2, astP3, astP4, astP5, astP6 };
		Point[] pA2 = { ast2P1, ast2P2, ast2P3, ast2P4, ast2P5, ast2P6 };
		Point[] pA3 = { ast3P1, ast3P2, ast3P3, ast3P4, ast3P5, ast3P6 };
		Point[] pA4 = { ast4P1, ast4P2, ast4P3, ast4P4, ast4P5, ast4P6 };
		Point[] pA5 = { ast5P1, ast5P2, ast5P3, ast5P4, ast5P5, ast5P6 };
		Point[] pA6 = { ast6P1, ast6P2, ast6P3, ast6P4, ast6P5, ast6P6 };
		
		//These create the three asteroids
		asteroid = new AsteroidComponent(pA, center, 50);
		asteroid2 = new AsteroidComponent(pA2, center2, 50);
		asteroid3 = new AsteroidComponent(pA3, center3, 50);
		asteroid4 = new AsteroidComponent(pA4, center4, 50);
		asteroid5 = new AsteroidComponent(pA5, center5, 50);
		asteroid6 = new AsteroidComponent(pA6, center6, 50);

		Point ast = new Point(500, 500);

		ship = new Ship(a, ast, 0);
		
		//Points used to determine whether the ship intersects an asteroid
		shipLoc = new Point(ship.getX(), ship.getY());
		
	}
	
	/*This paint method paints the whole frame every ten milliseconds
	 * (non-Javadoc)
	 * @see asteroids.Game#paint(java.awt.Graphics)
	 */
	public void paint(Graphics brush) {
		if(running){
			
			brush.setColor(Color.gray);
			brush.fillRect(0, 0, width, height);
			// sample code for printing message for debugging
			// counter is incremented and this message printed
			// each time the canvas is repainted
			counter++;
			//Makes the asteroids go faster
			if(speed < 2.5){
				speed += (counter *.01);
			}
			
			//Determines whether or not a collision happened
			if(asteroid.contains(shipLoc)){
				lives--;
				asteroid.destroyAst();
			}
			if(asteroid2.contains(shipLoc)){
				lives--;
				asteroid2.destroyAst();
			}
			if(asteroid3.contains(shipLoc)){
				lives--;
				asteroid3.destroyAst();
			}
			if(asteroid4.contains(shipLoc)){
				lives--;
				asteroid4.destroyAst();
			}
			if(asteroid5.contains(shipLoc)){
				lives--;
				asteroid5.destroyAst();
			}
			if(asteroid6.contains(shipLoc)){
				lives--;
				asteroid6.destroyAst();
			}
			
			
			brush.setColor(Color.white);
			//brush.drawString("Counter is " + counter, 10, 10);
			brush.drawString("Lives: " + lives, 10, 20);
			brush.drawString("Score: " + score, 10, 40);
			
			//instructions
			brush.drawString("PRESS SPACE", 10, 200);
			brush.drawString("TO START", 10 ,220);
			
			brush.drawString("SPACE TO", 10, 250);
			brush.drawString("SHOOT", 10, 270);
			
			brush.drawString("W --> UP", 10, 300);
			brush.drawString("S --> DOWN", 10, 320);
			brush.drawString("A --> LEFT", 10, 340);
			brush.drawString("D --> RIGHT", 10, 360);



			
			/*This makes the bullet shoot out when space bar is pressed,
			 *set the color, sets the starting points, and determines
			 *whether or not a collision happens
			 */
			if(SPC){
				brush.setColor(Color.black);

				buls[shots].paint(brush);
				for(int i = 0; i < 5; i++){
					buls[shots].move();
					bulLoc = new Point(buls[shots].getX(), buls[shots].getY());
					repaint();
					
				}
				if(!asteroid.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid.paint(brush);
					asteroid.move(speed);
				}
				if(asteroid.contains(bulLoc)){
					score += 10;
					asteroid.destroyAst();
				}
				if(!asteroid2.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid2.paint(brush);
					asteroid2.move(speed);
				}
				if(asteroid2.contains(bulLoc)){
					score += 10;
					asteroid2.destroyAst();
				}
				if(!asteroid3.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid3.paint(brush);
					asteroid3.move(speed);
				}
				if(asteroid3.contains(bulLoc)){
					score += 10;
					asteroid3.destroyAst();
				}
				if(!asteroid4.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid4.paint(brush);
					asteroid4.move(speed);
				}
				if(asteroid4.contains(bulLoc)){
					score += 10;
					asteroid4.destroyAst();
				}
				if(!asteroid5.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid5.paint(brush);
					asteroid5.move(speed);
				}
				if(asteroid5.contains(bulLoc)){
					score += 10;
					asteroid5.destroyAst();
				}
				if(!asteroid6.contains(bulLoc)){
					brush.setColor(Color.green);
					asteroid6.paint(brush);
					asteroid6.move(speed);
				}
				if(asteroid6.contains(bulLoc)){
					score += 10;
					asteroid6.destroyAst();
				}
				
				
			}
			
			//Determines ship color
			brush.setColor(Color.orange);
			ship.paint(brush);
			
			shipLoc = new Point(ship.getX(), ship.getY());
			
			
			//Stops game is no live are remaining and shows end of game screen
			if(lives == 0){
				running=false;
				brush.setColor(Color.black);

				brush.clearRect(0, 0, width, height);		
				brush.drawString("GAME OVER :(",  450, 400);
				brush.drawString("Score: " + score, 450, 440);
			}
			
			//Stops game if the player wins the game and chows a congrats message
			if(counter == 20000 || score == 50000){
				running = false;
				brush.setColor(Color.black);
				brush.clearRect(0, 0, width, height);
				brush.drawString("CONGRATULATIONS", 450, 400);
				brush.drawString("YOU WON!!!!!!!!!!!!!!!!!!!!", 450, 420);
				brush.drawString("Score: " + score, 450, 450);
			}
		}
		

	}

	/*
	 * This main statement runs the whole game
	 */
	public static void main(String[] args) {
		AsteroidsGame a = new AsteroidsGame();
		a.repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	/*This method enables us to move the ship in all directions and shoot
	 * bullets when space bar is pressed
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_D && ship.getX() < 980) {
			right = true;
			ship.moveRight(right);
		}
		if (e.getKeyCode() == KeyEvent.VK_A && ship.getX() > 15) {
			left = true;
			ship.moveLeft(left);
		}
		if (e.getKeyCode() == KeyEvent.VK_W && ship.getY() > 10) {
			up = true;
			ship.moveUp(up);
		}
		if (e.getKeyCode() == KeyEvent.VK_S && ship.getY() < 750) {
			down = true;
			ship.moveDown(down);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			SPC = true;
			shots++;
			buls[shots] = new BulletComponent(ship.getX()+2, ship.getY()-14, ship.getX()+2, ship.getY()-4);
			bulLoc = new Point(buls[shots].getX(), buls[shots].getY());
		}
	}

	/*This method confirms that you no longer move once a key is released
	 * (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		right = false;
		up = false;
		down = false;
		left = false;

	}
}
