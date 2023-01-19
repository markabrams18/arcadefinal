package arcade;



import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class brickbreaker {
	
	JFrame frame;
	JPanel panel;

	public brickbreaker() {
		frame = new JFrame("brick breaker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
	
		panel=new brickerbrickeranime();
		
		frame.add(panel);
		
		frame.setVisible(true);
	}
}
