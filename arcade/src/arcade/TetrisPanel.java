package arcade;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class TetrisPanel extends JPanel{
	
	final int WIDTH = 400;
	final int HEIGHT = 400;
	
	
	int score;
	
	boolean upArrowR = false;
	boolean downArrow = false;
	boolean leftArrow = false;
	boolean rightArrow = false;
	
	boolean spaceBar = false;
	boolean cSave = false;

	
	
	TetrisPanel(){
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setFocusable(true);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case 38: upArrowR = true;break;
				case 40: downArrow = true;break;
				
				case 37: leftArrow = true;break;
				case 39: rightArrow = true;break;
				
				case 49: spaceBar = true;break;
				case 67: cSave = true;break;
				
				default: System.out.println(e.getKeyCode());
				
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case 38: upArrowR = false;break;
				case 40: downArrow = false;break;
				
				case 37: leftArrow = false;break;
				case 39: rightArrow = false;break;
				
				case 49: spaceBar = false;break;
				case 67: cSave = false;break;
				
				default: System.out.println(e.getKeyCode());
				
				}
			}
			
		});
	}
}
