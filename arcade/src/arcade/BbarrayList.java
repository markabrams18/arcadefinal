package arcade;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BbarrayList {
	Image bricks;
	int bricksx;
	int x,y;
	int bricksy;
	public BbarrayList(){
		bricks = new ImageIcon("brick.png").getImage();
		x=5;
		y=5;
		bricksx=20;
		bricksy=20;
	}
	public Image addbrick() {
		return bricks;
	}
	public int bx() {
		return bricksx;
	}
	public int by() {
		return bricksy;
	}
}
