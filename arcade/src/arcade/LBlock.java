package arcade;

import javax.swing.ImageIcon;

public class LBlock {
	int[][] LShape = new int[3][3];
	int x, y;
	
	
	public LBlock() {
		
		
		for(int x = 0; x < LShape.length; x ++) {
			for(int y = 0; y < LShape[0].length; y ++) {
				LShape[x][y] = 0;
			}
			
		}
		
	}
	
	public void upShape() {
		for(int x = 0; x < LShape.length; x ++) {
			for(int y = 0; y < LShape[0].length; y ++) {
				LShape[x][y] = 0;
			}
		}
		LShape[1][0] = 1;
		LShape[1][1] = 1;
		LShape[1][2] = 1;
		LShape[2][2] = 1;
	}
	
	public void rightShape() {
		for(int x = 0; x < LShape.length; x ++) {
			for(int y = 0; y < LShape[0].length; y ++) {
				LShape[x][y] = 0;
			}
		}
		LShape[0][1] = 1;
		LShape[1][1] = 1;
		LShape[2][1] = 1;
		LShape[0][2] = 1;
	}
	
	public void downShape() {
		for(int x = 0; x < LShape.length; x ++) {
			for(int y = 0; y < LShape[0].length; y ++) {
				LShape[x][y] = 0;
			}
		}
		LShape[1][0] = 1;
		LShape[1][1] = 1;
		LShape[1][2] = 1;
		LShape[0][0] = 1;
	}
	
	public void leftShape() {
		for(int x = 0; x < LShape.length; x ++) {
			for(int y = 0; y < LShape[0].length; y ++) {
				LShape[x][y] = 0;
			}
		}
		LShape[2][1] = 1;
		LShape[1][1] = 1;
		LShape[0][1] = 1;
		LShape[2][0] = 1;
	}
	
	public int[][] getShape(){
		return LShape;
	}
}
