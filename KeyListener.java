package asteroids;
import java.awt.event.*;

public interface KeyListener {
	
	void keyTyped(KeyEvent e);
	void keyPressed(KeyEvent e);
	void keyReleased(KeyEvent e);
}
