package arcade;

import java.awt.Color;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	JButton start1, start2, start3,start4;
	JTextField name;
	Image titlePage, tetris, brickbreaker,brick,pong,pacman;
	String name1;
	boolean brickt,tetrist,pongt,pact=false;
	public arcadeTitlePage() {
		Database d = new Database();
		frame = new JFrame("arcade game");
		brickL= new JLabel("Play BrickBreaker");
		brickL.setForeground(Color.ORANGE);
		brick= new ImageIcon("brick.png").getImage();
		start1= new JButton(new ImageIcon(brick));
		
		start1.setContentAreaFilled(false);
		start1.setBorderPainted(false);
		titlepageI= new JLabel();
		titlePage= new ImageIcon("arcadetitlepage.png").getImage();
		//brickbreaker= new ImageIcon("bbbg.png").getImage();
		titlepageI.setIcon(new ImageIcon(titlePage));
		//brickbreakerI= new JLabel();
		//brickbreakerI.setIcon(new ImageIcon(brickbreaker));
		entern = new JLabel("Enter your name");
		name = new JTextField(25);
		//panel= new JPanel();
		
		
	
		
		entern.setBounds(200,200,150,25);
		name.setBounds(200, 225, 150, 25);
		entern.setVisible(false);
		name.setVisible(false);
		start1.setBounds(200,250,50,50);
		brickL.setBounds(250,250,200,50);
		brickL.setVisible(true);
		start1.setVisible(true);
		getName();
		start1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e1) {
				// TODO Auto-generated method stub
				brickt=true;
			}
			
		});
		start2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e2) {
				// TODO Auto-generated method stub
				tetrist=true;
			}
			
		});
		start3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e3) {
				// TODO Auto-generated method stub
				pongt=true;
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
		frame.add(brickL);
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

	public void tetris() {
		getName();
		AnimationTetris t = new AnimationTetris();
	}
	public void getGame() {
		if(brickt=true) {
			brickbreaker b = new brickbreaker();
		}else if(tetrist=true) {
			AnimationTetris p = new AnimationTetris();
		}else if(pongt=true) {
			
		}else if(pact=true) {
			
		}
	}
}
