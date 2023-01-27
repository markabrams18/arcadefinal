package arcade;

import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class arcadeTitlePage {
	JPanel panel,panel1;
	JFrame frame;
	JLabel entern,brickbreakerI,TetrisI,pongI,pacmanI,titlepageI,brickL;
	JButton start1, start2, start3,start4,exit,start,changeName;
	JTextField name;
	Image titlePage, tetris,brick,pong,pacman;
	String name1;
	boolean brickt,tetrist,pongt,pact,exit1=false;
	public arcadeTitlePage() {
	
		frame = new JFrame("arcade game");
		brickL= new JLabel("Play BrickBreaker");
		brickL.setForeground(Color.ORANGE);
		brick= new ImageIcon("brick.png").getImage();
		tetris = new ImageIcon("redBlock.png").getImage();
		TetrisI= new JLabel("Play Tetris");
		TetrisI.setForeground(Color.RED);
		pong = new ImageIcon("ball.png").getImage();
		pongI = new JLabel("Play pong");
		pongI.setForeground(Color.MAGENTA);
		
		start1= new JButton(new ImageIcon(brick));
		
		start2= new JButton(new ImageIcon(tetris));
		start3= new JButton(new ImageIcon(pong));
		start4 = new JButton(new ImageIcon()+"Play Pacman");
		start1.setContentAreaFilled(false);
		start1.setBorderPainted(false);
		start2.setContentAreaFilled(false);
		start2.setBorderPainted(false);
		start3.setContentAreaFilled(false);
		start3.setBorderPainted(false);
		
		titlepageI= new JLabel();
		titlePage= new ImageIcon("arcadetitlepage.png").getImage();
		
		titlepageI.setIcon(new ImageIcon(titlePage));
		
		entern = new JLabel("Enter your name");
		name = new JTextField(25);
		
		frame.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode()==27) {
					exit1=true;
					
				}
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println(e.getKeyCode());
				switch(e.getKeyCode()) {
				case 27: exit1=true; break;
				
			
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				switch(e.getKeyCode()) {
				//case 27: exit1=false; break;
				
				
				
				}
				
				
			}
			
		});
		
	
		
		entern.setBounds(200,200,150,25);
		name.setBounds(200, 225, 150, 25);
		entern.setVisible(false);
		name.setVisible(false);
		start1.setBounds(150,200,50,50);
		brickL.setBounds(200,200,200,50);
		start2.setBounds(150,250,50,50);
		TetrisI.setBounds(200,250,200,50);
		start3.setBounds(150,300,50,50);
		pongI.setBounds(200,300,200,50);
		brickL.setVisible(true);
		start1.setVisible(true);
		start2.setVisible(true);
		TetrisI.setVisible(true);
		start3.setVisible(true);
		pongI.setVisible(true);
		start1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {
				// TODO Auto-generated method stub
				
					brickbreaker b = new brickbreaker();
					
					b.frame.remove(panel);
					
				if(exit1==true){
					System.out.println("beta");
					getMenu();
				}
				
				
			
			}
			
		});
		start2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) {
				// TODO Auto-generated method stub
				if(exit1==false) {
					AnimationTetris p = new AnimationTetris();
				}
				
			}
			
		});
		start3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e3) {
				// TODO Auto-generated method stub
				if(exit1==false) {
					AnimationPong p = new AnimationPong();
					
					
				}
				
			}
			
		});
		start4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e4) {
				// TODO Auto-generated method stub
				pact=true;
			}
			
		});
		
		
		
		frame.setContentPane(titlepageI);
		frame.add(start1);
		frame.add(start2);
		frame.add(start3);
		frame.add(start4);	
		
		frame.add(brickL);
		frame.add(TetrisI);
		frame.add(pongI);
		//frame.add(pacmanI);
		frame.add(entern);
		frame.add(name);
		frame.setVisible(true);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void getName() {
		Database d = new Database();
		entern.setVisible(true);
		name.setVisible(true);
		name1= name.getText();
		d.playerName(name1);
		
	}

	

	public void getMenu() {
		
			
			frame.setContentPane(titlepageI);
			start1.setVisible(true);
		
	}
	
}
