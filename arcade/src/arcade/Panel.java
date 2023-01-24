package arcade;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
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
import java.util.Random;
public class Panel extends JPanel{
	
	boolean flag;
	
	final int WIDTH = 1313;
	final int HEIGHT = 735;
	
	Image platform, platform2, ball, bgImage;
	int num = 0;
	
	int x = 0;
	int y = 250;
	
	int x2 = 1275;
	int y2 = 250;
	
	int x3 = 700;
	int y3 = 200;
	
	int x3Speed = 15;
	int y3Speed = 6;
	
	int rPt = 0;
	int bPt = 0;
	
	String red;
	String blue;
	
	Timer timer;

	boolean rwin = false;
	boolean bwin = false;

	boolean up = false;
	boolean down = false;
	boolean upArrow = false;
	boolean downArrow = false;
	
	Panel(){

		
		Random r = new Random();
		
		num = r.nextInt(2)+1;
		
		
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		this.setFocusable(true);
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			// blue side player 
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
				case 87: up = true; break;
				case 83: down = true; break;
				
				case 38: upArrow = true; break;
				case 40: downArrow = true; break;
				
				default: System.out.println(e.getKeyCode());
				}
				
			}
			// red side player
			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				case 87: up = false; break;
				case 83: down = false; break;
				
				case 38: upArrow = false; break;
				case 40: downArrow = false; break;
				
				default: System.out.println(e.getKeyCode());
				}
			}
			
		});
		
		platform = new ImageIcon("blueplatform.png").getImage();
		platform2 = new ImageIcon("redplatform.png").getImage();
		bgImage = new ImageIcon("bgPong.png").getImage();
		ball = new ImageIcon("ball.png").getImage();
		
		/**
		 * timer
		 */
		timer = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				y3 = y3 + y3Speed;
				x3 = x3 + x3Speed;
				
				
				// blue team
				if(bPt == 8) {
					bwin = true;
				}
				
				if(rPt == 8) {
					rwin = true;
				}
				
				
				if(flag) {
					flag = false;
					if(num == 1) {
						
						x3Speed = x3Speed * -1;
						y3Speed = y3Speed * -1;

					}else {
						
					}
				}
				
				//points or blue
				if(x3 > 1275) {
					bPt +=1;
					
					x3 = 700;
					y3 = 200;
					num = r.nextInt(2)+1;
					flag = true;
				}
				blue = Integer.toString(bPt);
				

				// points for red 
				if(x3 < 1) {
					rPt +=1;
					
					x3 = 700;
					y3 = 200;
					num = r.nextInt(2)+1;
					
					flag = true;
				}
				
				red = Integer.toString(rPt);
				
				
				if(y3 < 0|| y3 > 680) {
					y3Speed = y3Speed * -1;
				}
				
				// blue platform bounce
				if(x3 < x + platform.getWidth(null) && x < x3 + ball.getWidth(null) && y3 < y + platform.getHeight(null) && y < y3 + ball.getHeight(null)) {
					
					x3Speed = x3Speed * -1;

				}
				
				//red platform bounce
				if(x3 < x2 + platform2.getWidth(null) && x2 < x3 + ball.getWidth(null) && y3 < y2 + platform2.getHeight(null) && y2 < y3 + ball.getHeight(null)) {
					
					x3Speed = x3Speed * -1;

				}
				
				// prevents the platforms from going off 
				if(up) {
					if(y> 0) {
						y -= 5;
					}
				}
				if(down) {
					if(y < 470) {
						y += 5;
					}
				}
				// prevents the platforms from going off
				if(upArrow) {
					if(y2 > 0) {
						y2 -= 5;
					}

				}
				if(downArrow) {
					if(y2 < 470) {
						y2 += 5;
					}
				}
				repaint();
			}
			
		});
		
		timer.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g2D.drawImage(bgImage, 0, 0, null);
		
		g2D.drawImage(platform, x, y, null);
		
		g2D.drawImage(platform2, x2, y2, null);
		
		g2D.drawImage(ball, x3, y3, null);
		
					
		Font font = new Font("Serif", Font.PLAIN, 40);		
		g2D.setFont(font);
		g2D.setColor(Color.white);
		g2D.drawString(blue, 300,50);
		
		g2D.drawString(red, 1000, 50);
		Font fontWin = new Font("Serif", Font.PLAIN, 100);
		
		// winner for the red player and blue 
		if(rwin) {
			g2D.drawString("Red Wins!", 800, 300);
			y3Speed =0;
			x3Speed= 0;
		}else if(bwin) {
			g2D.drawString("Blue Wins", 350, 300);
			y3Speed =0;
			x3Speed= 0;
		}
		
	}
}
