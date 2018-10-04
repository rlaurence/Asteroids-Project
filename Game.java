package asteroids;


import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;
import java.awt.Polygon;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;


public abstract class Game extends Canvas{
	protected boolean on = true;
	protected int width, height;
	protected Image buffer;

	public Game(String name, int inWidth, int inHeight) {
		width = inWidth;
		height = inHeight;

		// Frame can be read as 'window' here.
		Frame frame = new Frame(name);
		frame.add(this);
		frame.setSize(width,height);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() { 
			public void windowClosing(WindowEvent e) {System.exit(0);} 
		});

		buffer = createImage(width, height);
	}

	// 'paint' will be called every tenth of a second that the game is on.
	abstract public void paint(Graphics brush);

	// 'update' paints to a buffer then to the screen, then waits a tenth of
	// a second before repeating itself, assuming the game is on. This is done
	// to avoid a choppy painting experience if repainted in pieces.
	public void update(Graphics brush) {
		paint(buffer.getGraphics());
		brush.drawImage(buffer,0,0,this);
		if (on) {
			sleep(10); 
			repaint();
		}
	}

	// 'sleep' is a simple helper function used in 'update'.
	private void sleep(int time) {
		try {Thread.sleep(time);} catch(Exception exc){};
	}

	
	
	//This is all old code that didn't end up working out
	
	/*private BufferStrategy buff;
	private Graphics g;
	private Frame frame;
	private Thread thread;
	private boolean running = true;
	public static KeyManager input;
	AsteroidComponent[] aster = new AsteroidComponent[1050];
	TriangleComponent ship = new TriangleComponent();
	BulletComponent[] bullet = new BulletComponent[100000];
	//AsteroidComponent aster = new AsteroidComponent();
	//private static AsteroidComponent aster;
	//private static TriangleComponent ship;
	int lives = 25;
	//private String title;
	//private int width, height; 
	final int SPACER = 1;
	private static final int WIDTH = 700, HEIGHT = 500, SCALE = 2;
	
	@Override
	public void keyPressed(KeyEvent e){
		int i = 0;
		if(e.getKeyCode() == KeyEvent.VK_A && (ship.getX2() > 12)){
			ship.moveShip(ship.getX()-20, ship.getX2()-20, ship.getX3()-20, ship.getY(), ship.getY2(), ship.getY3());
			
		}else if(e.getKeyCode() == KeyEvent.VK_D && (ship.getX3() < 1380)){
			ship.moveShip(ship.getX()+20, ship.getX2()+20, ship.getX3()+20, ship.getY(), ship.getY2(), ship.getY3());
			
		}else if(e.getKeyCode() == KeyEvent.VK_S && (ship.getY2() < 830)){
			ship.moveShip(ship.getX(), ship.getX2(), ship.getX3(), ship.getY()+20, ship.getY2()+20, ship.getY3()+20);
			
		}else if(e.getKeyCode() == KeyEvent.VK_W && (ship.getY() > 0)){
			ship.moveShip(ship.getX(), ship.getX2(), ship.getX3(), ship.getY()-20, ship.getY2()-20, ship.getY3()-20);
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE){
			bullet[i] = new BulletComponent(ship.getX(), ship.getY());
			//bullet[i].moveBullet
			i++;
			
			
		}
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {};
	@Override
	public void keyTyped(KeyEvent e) {};
	
	
	public Game(){
		for(int i = 0; i < aster.length; i++){
			aster[i] = new AsteroidComponent();
		}
		for(int i = 0; i < bullet.length; i++){
			bullet[i] = new BulletComponent(ship.getX(), ship.getY()-10);
		}
		addKeyListener(this);
		setFocusable(true);
	}
	
	
	
	/*public Game(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
		input = new KeyManager();
	}*/
	
	
	/*private void initialize(){
		frame = new Frame(title, width, height);
		frame.getFrame().addKeyListener(input);
		
	}*/
	
	
	
	/*public void run() {
		
		//initialize();
		// TODO Auto-generated method stub
		long lastTime = System.nanoTime();
		int fps = 60;
		double timePerTick = 1000000000/fps;
		double delta = 0;
		long now;
		
		int timer = 0;
		int tickCounter = 0;
		
		while(running){
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				tickCounter++;
				delta--;
			}
			render();
			
			if(timer >=1000000000){
				System.out.println("ticks and Frames: " + tickCounter);
				tickCounter = 0;
				timer = 0;
			}
		}
	}
	
	private void tick(){
		//input.tick();
		
		
	}
	
	private void render(){
		buff = this.getBufferStrategy();
		//buff = frame.getCanvas().getBufferStrategy();
		if(buff == null){
			createBufferStrategy(3);
			//frame.getCanvas().createBufferStrategy(3);
			return;
		}
		g = buff.getDrawGraphics(); //clear screen
		//g.clearRect(0, 0, width, height);
		//g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE); //drawn here
		
		
		
		
		
		
		//end draw
		g.dispose();
		buff.show();
		
	} //New Java Beginner Game programming tutorial youtube. by codenmore
	
	public synchronized void start(){
		if(running) return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running) return;
		running = false;
		try{
		thread.join();
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}*/
	
	/*public void paint(Graphics g){	
		int i = 0;
		int level = 0;
		Graphics2D g2 = (Graphics2D) g;
		
		//ship.paint(g2);
		aster[i].paint(g2);
		aster[i+1].paint(g2);
		aster[i+2].paint(g2);
		//while(running){
			aster[i].moveAst(0.01);
			aster[i+1].moveAst(0.01);
			aster[i+2].moveAst(0.01);

		//}
		
		
		//moveBullet(g2);
		//aster[0].paint(g2);
		//moveAsters(g2);
		
		
	}
	
	
	
	
	public void moveAsters(Graphics g){		
		
		Graphics2D g2 = (Graphics2D) g;
		int level = 1;
		double speed = 0.01;
		int j = 0;
		int i = j;
		
		while(j < aster.length && running){
			
			while(i < (j+21) && running){
				
				while((aster[i].getY() < 1000) && (lives > 0) && running){
					aster[i].paint(g2);
					aster[i+1].paint(g2);
					aster[i+2].paint(g2);
					Pause.wait(speed);
					g.clearRect(0,0,getWidth(), getHeight());
					//aster[i].moveAst(aster[i].getX(), aster[i].getY() + SPACER);
					//aster[i+1].moveAst(aster[i+1].getX(), aster[i+1].getY() + SPACER);
					//aster[i+2].moveAst(aster[i+2].getX(), aster[i+2].getY() + SPACER);
					if(aster[i].getBottomY() == 1000){
						lives--;
					}
					if(aster[i+1].getBottomY() == 1000){
						lives--;
					}
					if(aster[i+2].getBottomY() == 1000){
						lives--;
					}
					if(lives == 0){
						running = false;
					}
				}
				aster[i].paint(g2);
				repaint();
				i += 3;
			}
			
			level++;
			if(level <= 25){
				speed /= 1.1;
			}else if(level > 25 && level < 50){
				speed = 0.001;
			}else{
				speed = 0.0005;
			}
			if(level < 51 && lives > 0){
				g2.drawString("Level " + level, 625, 300);
				g2.drawString("Lives Left: " + lives, 625, 320);
			}else if(level == 51){
				g2.drawString("CONGRATULATIONS, YOU WON!!!", 625, 300);
			}else if(lives == 0){
				g2.drawString("GAME OVER...YOU LOST.", 625, 300);
			}
		
			
			Pause.wait(3.0);
			j += 21;
		}
	}
	
	
	
	
	public static void main(String[] args){
		//Game game = new Game("Game Frame", 360, 240);
		
		/*game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		game.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));*/
		
		//input = new KeyManager();
		/*JFrame frame = new JFrame("Game Frame");
		Game game = new Game();
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//frame.addKeyListener(input);
		frame.setResizable(true);
		frame.add(game);
		frame.setVisible(true);
		
		/*aster = new AsteroidComponent();
		frame.add(aster);
		
		ship = new TriangleComponent();
		frame.add(ship);*/
		
		//////////////game.start();
		
		
}
	
