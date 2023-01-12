package arcade;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class brickerbrickeranime extends JPanel {
	final int WIDTH=800;
	final int HEIGHT =800;
	Timer timer;
	int xSpeed=5;
	int ySpeed=5;
	int xb,yb,sb;
	int brickx,bricky;
	int x=400;
	int y=750;
	int x2=15;
	int y2=15;
	boolean left,right=false;
	Image ball, paddle1,bbbg;
	Image brick ;
	ArrayList<BbarrayList> bricks;
	
	public brickerbrickeranime(){
		bricks= new ArrayList<BbarrayList>();
	
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		this.setLocation(brickx, bricky);
		this.setFocusable(true);
		paddle1=new ImageIcon("paddle.png").getImage();
		brick= new ImageIcon("brick.png").getImage();
		ball=new ImageIcon("ball.png").getImage();
		bbbg=new ImageIcon("bbbg.png").getImage();
		for(int i=0;i<46;i++) {
			int temp=i;
			bricks.add(new BbarrayList(brick,x2,y2,temp));
			System.out.println(bricks.get(i).bx()+"||"+ bricks.get(i).by());
			x2+=33;
			if(x2>760) {
				x2=15;
				y2+=40;
			}
		}
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
				
				
				if(left) {
					x-=5;
					
				}
				if(right) {
					x+=5;
					
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
			
			
		
	
	}
	
}
