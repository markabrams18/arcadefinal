package arcade;

public class ZShape {

	int[][] ZShape = new int[3][3];
	int x, y;
	
	public ZShape() {
		
		for(int x = 0; x < ZShape.length; x ++) {
			for(int y = 0; y < ZShape[0].length; y ++) {
				ZShape[x][y] = 0;
			}
			
		}
		
	}
	
	public void upShape() {
		for(int x = 0; x < ZShape.length; x ++) {
			for(int y = 0; y < ZShape[0].length; y ++) {
				ZShape[x][y] = 0;
			}
		}
		
		ZShape[0][0] =1;
		ZShape[1][0] =1;
		ZShape[1][1] =1;
		ZShape[2][1] =1;
		
	}
	
	public void leftShape() {
		for(int x = 0; x < ZShape.length; x ++) {
			for(int y = 0; y < ZShape[0].length; y ++) {
				ZShape[x][y] = 0;
			}
		}
		
		ZShape[0][2] =1;
		ZShape[0][1] =1;
		ZShape[1][1] =1;
		ZShape[1][0] =1;
		
	}
	
	public void downShape() {
		for(int x = 0; x < ZShape.length; x ++) {
			for(int y = 0; y < ZShape[0].length; y ++) {
				ZShape[x][y] = 0;
			}
		}
		
		ZShape[0][1] =1;
		ZShape[1][1] =1;
		ZShape[1][2] =1;
		ZShape[2][2] =1;
		
	}
	
	public void rightShape() {
		for(int x = 0; x < ZShape.length; x ++) {
			for(int y = 0; y < ZShape[0].length; y ++) {
				ZShape[x][y] = 0;
			}
		}
		
		ZShape[2][0] =1;
		ZShape[2][1] =1;
		ZShape[1][1] =1;
		ZShape[1][2] =1;
		
	}
	
	public int[][] getShape() {
		return ZShape;
	}
	
}
