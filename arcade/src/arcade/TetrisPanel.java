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
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TetrisPanel extends JPanel{
	
	final int WIDTH = 400;
	final int HEIGHT = 400;
	
	Image bgImage, rSquare, gSquare, pSquare, bSquare, randomSquare;

	Timer timer, timer2; 
	
	boolean upArrowR = false;
	boolean downArrow = false;
	boolean leftArrow = false;
	boolean rightArrow = false;
	
	boolean spaceBar = false;
	boolean cSave = false;

	LBlock l = new LBlock();
	TBlock t = new TBlock();
	ZShape z = new ZShape();
	OBlock o = new OBlock();
	int x = 296;
	int y = 29	;
	
	int score =0;
	String stScore;
	
	int num = 0;
	int random = 0;
	
	int[][] temp = new int[3][3];
	int tempx=0;
	int tempy=0;
	int turn = 1;
	int[][] currPos = new int[10][24];
	int lineCount = 1;
	
	
	TetrisPanel(){
		
		bgImage = new ImageIcon("TetrisBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();
		
		
		Random r = new Random();
		Random colorR = new Random();
		
		num = r.nextInt(4)+1;
		if(num == 1) {
			randomSquare = rSquare;
			
		}else if(num == 2) {
			randomSquare = gSquare;
			
		}else if (num == 3) {
			randomSquare = bSquare;
			
		}else if(num == 4) {
			randomSquare = pSquare;
			
		}
		
		random = r.nextInt(1)+1;
		System.out.println("Random Number is: "+random);
		
		if(random == 1) {
			l.upShape();
			temp = l.getShape();
			
		}else if(random == 2) {
			t.upShape();
			temp = t.getShape();
			
		}else if(random == 3) {
			z.upShape();
			temp = z.getShape();
			
		}else if(random == 4) {
			
			o.upShape();
			temp = o.getShape();
		}

		
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
				//left arrow
				case 37:
				if(x > 227) {
					x-=27;
				}
				break;
				
				//up arrow
				case 38: turn +=1;
					if(turn == 5) {
						turn = 1;
					}
				break;
				
				//right arrow
				case 39:
				if(x < 431) {
					x+= 27;
				}
				break;
				//down arrow
				case 40: 				
					if(y < 600) {
						y+= 27;
						System.out.println(y);
					}
				break;
				
				case 49: spaceBar = true;break;
				
				case 67: cSave = true;break;
				
				default: System.out.println(e.getKeyCode());
				}
				
				
				if(random == 1) {
					
					if(turn==1) {
						
						l.upShape();
						
					}else if(turn==2) {
						
						if(x <227) {
							x+=27;
							
						}
							
						l.rightShape();
						
					}else if(turn==3) {
						
						System.out.println(x);
						if(x < 227) {
							x+= 27;
						}
						
						l.downShape();
					}else if(turn ==4){
						
						if(x < 227) {
							x+= 27;
							
						}
						
						l.leftShape();
					}
					
					temp = l.getShape();
					
				}else if(random == 2) {
					
					if(turn==1) {
						
						if(x < 240) {
							x+= 27;
						}
						
						t.upShape();
					}else if(turn==2) {
						
						
						t.rightShape();
					}else if(turn==3) {
						
						if(x < 240) {
							x+= 27;
						}

						t.downShape();
					}else if(turn ==4){
						
						if(x < 240) {
							x+= 27;
						}
						
						t.leftShape();
					}
					
					temp = t.getShape();
					
				}else if(random == 3) {
					
					if(turn==1) {
						
						if(x < 240) {
							x+= 27;
						}
						
						z.upShape();
					}else if(turn==2) {
						
						
						z.rightShape();
					}else if(turn==3) {
						
						if(x < 240) {
							x+= 27;
						}
						
						z.downShape();
					}else if(turn ==4){
						
						if(x < 240) {
							x+= 27;
						}
						
						z.leftShape();
					}
					
					temp = z.getShape();
					
				}else if(random == 4) {
					if(x < 240) {
						x+= 27;
					}
					
					temp = o.getShape();
				}
				
				System.out.println(turn);
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
		
		bgImage = new ImageIcon("TetrisBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();
		
		
		
		
		timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(temp[2][0] == 0 || temp[2][1] == 0 || temp [2][2] == 0) {
					
				}
				
				
				
				
				
				//stScore = Integer.toString(score);
				repaint();
			}
			
		});
		timer.start();
		
		timer2 = new Timer (1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(y <= 600) {
					y+= 27;
				}
				
			}
			
		});
		
		//timer2.start();
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g2D.drawImage(bgImage, 0, 0, null);
		
		/**
		Font font = new Font("Serif", Font.PLAIN, 40);		
		g2D.setFont(font);
		g2D.setColor(Color.white);
		g2D.drawString(stScore, 50,100);
		*/
		
		if(temp[0][0] == 1) {
			tempx=x-26;
			tempy=y-26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[1][0] == 1) {
			tempx=x;
			tempy=y-26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[2][0] == 1) {
			tempx=x+26;
			tempy=y-26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[0][1] == 1) {
			tempx = x-26;
			tempy = y;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[1][1] == 1) {
			tempx=x;
			tempy=y;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[2][1] == 1) {
			tempx=x+26;
			tempy=y;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[0][2] == 1) {
			tempx = x-26;
			tempy = y+26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[1][2] == 1) {
			tempx = x;
			tempy = y+26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		if(temp[2][2] == 1) {
			tempx=x+26;
			tempy=y+26;
			g2D.drawImage(randomSquare, tempx, tempy, null);
			
		}
		
	}
}
