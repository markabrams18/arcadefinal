package arcade;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class brickerbrickeranime extends JPanel {
	final int WIDTH=800;
	final int HEIGHT =800;
	Timer timer;
	int xSpeed=1;
	int ySpeed=1;
	int brickx,bricky;
	int x=0;
	int y=0;
	int x2=1;
	int y2=1;
	boolean left,right,up,down=false;
	Image ball, paddle1;
	Image bricks ;
	Image bArray[];
	brickerbrickeranime(){
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation(brickx, bricky);
		paddle1=new ImageIcon("paddle.png").getImage();
		bricks=new ImageIcon("brick.png").getImage();
		ball=new ImageIcon("ball.png").getImage();
		this.addKeyListener(new KeyListener() {
		
		
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='a') {
					x2-=xSpeed;
				}
			
				
				if(e.getKeyChar()=='d') {
					x2+=xSpeed;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch(e.getKeyCode()) {
				case 65: left=true; break;
				
				case 68: right = true; break;
			
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case 65: left=false; break;
				
				case 68: right = false; break;
				
				}
				
				
			}
			
		});
		bricks=new ImageIcon("brick.png").getImage();
		for(int i=0;i<50;i++) {
			bArray[i]=bricks;
			if(i>10||i>20||i>30||i>40) {
				bricky = bricky + 2;
			}
		}
		timer = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				if(left) {
					x2-=1;
					
				}
				if(right) {
					x2+=1;
					
				}
		
				repaint();
			}
			
		});
		
		
		timer.start();
		
		
		
	}
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		
		
		if(right) {
		g2d.drawImage(paddle1,x2,y2,null);
		}else if(left) {
			g2d.drawImage(paddle1,x2,y2,null);
		}
		//g2d.drawImage(enemy2,x2,y2,null);
		
			
			
		
	
	}
	
}
