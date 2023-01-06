package arcade;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationTetris {

	JFrame frame;
	JPanel panel;
	
	public AnimationTetris() {
		
		frame = new JFrame("Tetris");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		
		panel = new TetrisPanel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
