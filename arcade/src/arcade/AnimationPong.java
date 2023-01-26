package arcade;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnimationPong {
	
	JFrame frame;
	JPanel panel;
	
	public AnimationPong() {
		frame = new JFrame("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setSize(1313,735);
		frame.setLocationRelativeTo(null);
		
		panel = new Panel();
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
