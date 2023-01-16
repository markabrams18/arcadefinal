package arcade;

import java.awt.Image;

import javax.swing.ImageIcon;

public class BbarrayList {
	Image bricks;
	int bricksx;
	int x,y;
	int bricksy;
	int numofb;
	public BbarrayList(Image b,int bxx,int byy,int num){
		bricks=b;
		bricksx=bxx;
		bricksy=byy;
		numofb=num;
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
	public int numofi() {
		return numofb;
	}
	public int BrickWidth() {
		return bricks.getWidth(null);
	}
	public int BrickHeight() {
		return bricks.getWidth(null);
	}
}
