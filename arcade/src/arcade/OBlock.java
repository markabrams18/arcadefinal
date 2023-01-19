package arcade;

public class OBlock {
	
	int[][] OShape = new int[3][3];
	int x, y;
	
	public OBlock() {
		
		for(int x = 0; x < OShape.length; x ++) {
			for(int y = 0; y < OShape[0].length; y ++) {
				OShape[x][y] = 0;
			}
		}
		
	}
	public void upShape() {
		for(int x = 0; x < OShape.length; x ++) {
			for(int y = 0; y < OShape[0].length; y ++) {
				OShape[x][y] = 0;
			}
		}
		
		OShape[0][1] =1;
		OShape[0][2] =1;
		OShape[1][1] =1;
		OShape[1][2] =1;
		
	}
	
	public int[][] getShape(){
		return OShape;
	}
}
