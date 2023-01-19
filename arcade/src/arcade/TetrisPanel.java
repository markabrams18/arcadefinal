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
	//297
	int x =52;
	int y = 26;
	//29
	int score = 0;
	String stScore;
	
	private final int blockSize = 26;
	
	private final int brdWidth = 10;
	private final int brdHeight = 24;
	
	
	
	int num = 0;
	int random = 0;
	
	int[][] temp = new int[3][3];
	
	int tempx = 2;
	int tempy = 0;
	
	int turn = 1;
	int[][] tempSetUp = new int[12][25];
	int[][] currPos = new int[12][25];
	int lineCount = 1;
	
	boolean flag = true;
	boolean once = true;
	
	TetrisPanel(){
		
		bgImage = new ImageIcon("TetrisBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();
		
		
		Random r = new Random();
		Random colorR = new Random();
		
		num = r.nextInt(4)+1;
		
		System.out.println("Random Num Color Is: " + num);

		
		random = r.nextInt(4)+1;
		System.out.println("Random Number is: "+random);
		

		
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
				if(x > 0) {
					x-=26;
					System.out.println(x);
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
				if(x < 200) {
					x+= 26;
				}
				break;
				//down arrow
				case 40: 				
					if(y < 572) {
						y+= 26;
						System.out.println(y);
					}
				break;
				
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
		//pictures
		bgImage = new ImageIcon("blackBG.png").getImage();
		rSquare = new ImageIcon("redBlock.png").getImage();
		bSquare = new ImageIcon("blueBlock.png").getImage();
		gSquare = new ImageIcon("greenBlock.png").getImage();
		pSquare = new ImageIcon("purpleBlock.png").getImage();
		
		
		
		
		timer = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(once) {
					tempSetUp();
					
					
					for(int j = 0; j < tempSetUp[0].length; j ++ ) {
						for(int i = 0; i < tempSetUp.length; i ++) {
							
							
							System.out.print(tempSetUp[i][j] + " ");
						}
						System.out.println(" ");
					}
					
					once = false;
				}
				
				
				
				
				
				
				

				
				// gets the shape
				
					if(num == 1) {
						randomSquare = rSquare;
						
					}else if(num == 2) {
						randomSquare = gSquare;
						
					}else if (num == 3) {
						randomSquare = bSquare;
						
					}else if(num == 4) {
						randomSquare = pSquare;
						
					}
					
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
					
					if(random == 1) {
						
						if(turn==1) {
							
							l.upShape();
							
						}else if(turn==2) {
							
							if(x < 0) {
								x+=26;
								
							}
								
							l.rightShape();
							
						}else if(turn==3) {
							
							System.out.println(x);
							if(x < 0) {
								x+= 26;
							}
							
							l.downShape();
						}else if(turn ==4){
							
							if(x < 0) {
								x+= 26;
								
							}
							
							l.leftShape();
						}
						
						temp = l.getShape();
						
					}else if(random == 2) {
						
						if(turn==1) {
							
							if(x < 0) {
								x+= 26;
							}
							
							t.upShape();
						}else if(turn==2) {
							
							
							t.rightShape();
						}else if(turn==3) {
							
							if(x < 0) {
								x+= 26;
							}

							t.downShape();
						}else if(turn ==4){
							
							if(x < 0) {
								x+= 26;
							}
							
							t.leftShape();
						}
						
						temp = t.getShape();
						
					}else if(random == 3) {
						
						if(turn==1) {
							
							if(x < 0) {
								x+= 26;
							}
							
							z.upShape();
						}else if(turn==2) {
							
							
							z.rightShape();
						}else if(turn==3) {
							
							if(x < 0) {
								x+= 26;
							}
							
							z.downShape();
						}else if(turn ==4){
							
							if(x < 0) {
								x+= 26;
							}
							
							z.leftShape();
						}
						
						temp = z.getShape();
						
					}else if(random == 4) {
						if(x < 0) {
							x+= 26;
						}
						
						temp = o.getShape();
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
	
	public void tempSetUp() {
		for(int j = 0; j < tempSetUp[0].length; j ++ ) {
			for(int i = 0; i < tempSetUp.length; i ++) {
				
				tempSetUp[i][j] = 0;
				
			}
		}
	}
	
	public void FinalSetUp() {
		for(int j = 0; j < currPos[0].length; j ++ ) {
			for(int i = 0; i < currPos.length; i ++) {
				
				currPos[i][j] = 0;
				
				if(i == 0 || i == 9) {
					currPos[i][j] = 1;
				}else if(j == 23) {
					currPos[i][j] = 1;
				}
				System.out.print(currPos[i][j] + " ");
			}
			System.out.println(" ");
		}

		
		
		
	}
	
	public void paint(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g2D.drawImage(bgImage, 0, 0, null);
		

		g2D.setColor(Color.white);
		
		for(int i = 0; i <= brdHeight; i ++) {
			
			g2D.drawLine(0, i*blockSize, brdWidth*blockSize, i * blockSize);
		}
		
		for(int i = 0; i <= brdWidth; i ++) {
			
			g2D.drawLine(i * blockSize, 0, i * blockSize, brdHeight*26);
		}
		
		
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
