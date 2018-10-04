package asteroids;
import java.awt.*;
import java.awt.geom.Line2D;

import javax.swing.JComponent;

public class BulletComponent{
	
	private Point position;
	
	private Line2D.Double bul;
	
	int x, y, x2, y2;

	public BulletComponent(int Ax, int Ay, int Ax2, int Ay2){
		x = Ax;
		y = Ay;
		x2 = Ax2;
		y2 = Ay2;
		position = new Point(x, y);
		bul = new Line2D.Double(x, y, x2, y2);	
	}
	
	 public void move(){
		 if(y2 > -10){
			 y-=0.5;
			 y2-=0.5;
			 bul = new Line2D.Double(x,y,x2,y2);
		 }
		 if(y2==0){
			 y2 = 0;
		 }
	 }
	 
	 public void paint(Graphics g){
		 Graphics2D g2 = (Graphics2D) g;
		 g2.draw(bul);
	 }
	 
	 public int getX(){
		 return x;
	 }
	 
	 public int getY(){
		 return y;
	 }
	 
	 public void destroyBull(){
		 
	 }
	 
	 
	 //Old code that didn't work out
	
	/*Line2D.Double bullet;
	public int startX;
	public int startY;
	
	public BulletComponent(int x, int y){
		startX = x;
		startY = y;
		bullet = new Line2D.Double(startX, startY, startX, startY + 10);
		
	}
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		g2.draw(bullet);
		repaint();
	}
	
	/*public void shoot(int x, int y){
		startX = x;
		startY = y;
		bullet = new Line2D.Double(startX, startY, startX, startY + 10);
		while(startY > -11){
			startY -= 10;
			Pause.wait(.1);
			bullet = new Line2D.Double(startX, startY, startX, startY + 10);
			
			repaint();
		}
		repaint();
	}*/
	
	/*public void move(int x, int y){
		bullet = new Line2D.Double(x, y, x, y + 10);
		startY = y;
		repaint();
	}
	
	public int getY(){
		return startY;
	}
	
	public void setY(int y){
		startY = y;
	}*/
}
