package arcade;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class arcadeTitlePage {
	JPanel panel,panel1;
	JFrame frame;
	JButton start1, start2, start3,start4;
	JTextField name;
	Image tetris, brickbreaker,pong,pacman;
	String name1;
	public arcadeTitlePage() {
		frame = new JFrame("arcade game");
		Database d = new Database();
		name = new JTextField(25);
		name.setBounds(200, 200, 25, 25);
	}
	public String getName() {
		panel.add(name);
		return name1;
		
	}
	public void brickBreaker() {
		brickerbrickeranime b = new brickerbrickeranime();
	}
	public void tetris() {
		//TetrisPanel t = new TetrisPanel();
	}
}
