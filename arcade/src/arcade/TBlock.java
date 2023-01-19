package arcade;

public class TBlock {

	int[][] TShape = new int[3][3];
	int x, y;
	
	public TBlock() {
		
		for(int x = 0; x < TShape.length; x ++) {
			for(int y = 0; y < TShape[0].length; y ++) {
				TShape[x][y] = 0;
			}
			
		}
		
	}
	
	
	public void upShape() {
		
		for(int x = 0; x < TShape.length; x ++) {
			for(int y = 0; y < TShape[0].length; y ++) {
				TShape[x][y] = 0;
			}
		}
		TShape[0][0]= 1;
		TShape[1][0]= 1;
		TShape[2][0]= 1;
		TShape[1][1]= 1;
		
	}
	
	public void leftShape() {
		
		for(int x = 0; x < TShape.length; x ++) {
			for(int y = 0; y < TShape[0].length; y ++) {
				TShape[x][y] = 0;
			}
		}
		TShape[0][0]= 1;
		TShape[0][1]= 1;
		TShape[0][2]= 1;
		TShape[1][1]= 1;

	}
	
	
	public void downShape() {
		
		for(int x = 0; x < TShape.length; x ++) {
			for(int y = 0; y < TShape[0].length; y ++) {
				TShape[x][y] = 0;
			}
		}
		TShape[0][2]= 1;
		TShape[1][2]= 1;
		TShape[2][2]= 1;
		TShape[1][1]= 1;

		
	}
	
	public void rightShape() {
		
		for(int x = 0; x < TShape.length; x ++) {
			for(int y = 0; y < TShape[0].length; y ++) {
				TShape[x][y] = 0;
			}
		}
		TShape[2][0]= 1;
		TShape[2][1]= 1;
		TShape[2][2]= 1;
		TShape[1][1]= 1;

	}
	
	public int[][] getShape(){
		return TShape;
	}
}
