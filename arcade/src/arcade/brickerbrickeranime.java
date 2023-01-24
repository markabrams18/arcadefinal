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
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

public class brickerbrickeranime extends JPanel {
	final int WIDTH=800;
	final int HEIGHT =800;
	JButton start;
	Timer timer;
	int score;
	int xSpeed=5;
	int ySpeed=5;
	int sbx,sby=0;
	int xb=400,yb=730;
	int brickx,bricky;
	int x=400;
	int y=750;
	int x2=15;
	int y2=15;
	int numOfB=0;
	boolean left,right=false;
	boolean win=false;
	boolean lose=false;
	
	Image ball, paddle1,bbbg;
	Image brick ;
	ArrayList<BbarrayList> bricks;
	
	public brickerbrickeranime(){
		bricks= new ArrayList<BbarrayList>();
		start = new JButton();
		score=0;
		
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation(0, 0);
		this.setFocusable(true);
		paddle1=new ImageIcon("paddle.png").getImage();
		brick= new ImageIcon("brick.png").getImage();
		ball=new ImageIcon("ball.png").getImage();
		bbbg=new ImageIcon("bbbg.png").getImage();
		
	
		for(int i=0;i<46;i++) {
			int temp=i;
			bricks.add(new BbarrayList(brick,x2,y2,numOfB));
			numOfB=i;
			x2+=33;
			if(x2>760) {
				x2=15;
				y2+=40;
			}
		}
		sbx=5;
		sby=-5;
		this.addKeyListener(new KeyListener() {
		
		
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar()=='a') {
					x-=xSpeed;
					
				}
			
				
				if(e.getKeyChar()=='d') {
					x+=xSpeed;
				
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
		
		
		timer = new Timer(5, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// TODO Auto-generated method stub
				if(xb>WIDTH-ball.getWidth(null)-10||xb<0) {
					sbx=sbx*-1;
				}else if(yb<0) {
					sby=sby*-1;
				}else if(yb>HEIGHT-ball.getHeight(null)-35) {
					sby=0;
					sbx=0;
					lose=true;
				}
				xb=xb+sbx;
				yb=yb+sby;
				if(xb<x+paddle1.getWidth(null)&&x<xb+ball.getWidth(null)&&yb<y+paddle1.getHeight(null)&&y<yb+ball.getHeight(null)) {
				
					if(x-xb<-85) {
						sbx=xSpeed*1;
					}else if(x-xb<-75&&x-xb>-85) {
						sbx= (int) (xSpeed*1.75);
					}else if(x-xb<-65&&x-xb>-75) {
						sbx=(int) (xSpeed*1.5);
					}else if(x-xb<-55&&x-xb>-65) {
						sbx=(int) (xSpeed*1.25);
					}else if(x-xb<-45&&x-xb>-55) {
						sbx=sbx*1;
					}else if(x-xb<-35&&x-xb>-45) {
						sbx=sbx*1;
					}else if(x-xb<-25&&x-xb>-35) {
						sbx=(int)(xSpeed*-1.25);
					}else if(x-xb<-15&&x-xb>-25) {
						sbx=(int) (xSpeed*-1.5);
					}else if(x-xb<-5&&x-xb>-15) {
						sbx=(int) (xSpeed*-1.75);
					}else {
						sbx=xSpeed*-1;
					}
					sby=sby*-1;
					
				}
				for(int i=0;i<bricks.size();i++) {
					if(xb<bricks.get(i).bx()+bricks.get(i).BrickWidth()&&bricks.get(i).bx()<xb+ball.getWidth(null)&&yb<bricks.get(i).by()+bricks.get(i).BrickHeight()-10&&bricks.get(i).by()<yb+ball.getHeight(null)) {
						
						if(numOfB<=0) {
							win = true;
							sbx=0;
							sby=0;
						}
						numOfB-=1;
						sby=sby*-1;
						bricks.remove(i);
						score+=10;
						System.out.println(score);
					}
				}
				if(left) {
					x-=xSpeed;
					if(x<0) {
						x+=10;
					}
				
				}
			
				if(right) {
					x+=xSpeed;
					if(x>675) {
						x-=10;
					}
					
				
				}
	
				repaint();
			}
			
		});
	
		
		timer.start();
		
		
		
	}
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.drawImage(bbbg,0,0,null);
		for(int i=0;i<bricks.size();i++) {
			g2d.drawImage(((BbarrayList) bricks.get(i)).addbrick(), ((BbarrayList) bricks.get(i)).bx(), ((BbarrayList) bricks.get(i)).by(),null);
		}
		
		g2d.drawImage(paddle1, x, y, null);
		g2d.drawImage(ball,xb,yb,null);
		if(win) {
			Font font = new Font("Serif",Font.PLAIN,40);
			g2d.setFont(font);
			g2d.setColor(Color.BLACK);
			g2d.drawString("You win", 400, 400);
		}else if(lose){
			g2d.drawString("you lose",400,400);
		}
			
		
	
	}
	
}
