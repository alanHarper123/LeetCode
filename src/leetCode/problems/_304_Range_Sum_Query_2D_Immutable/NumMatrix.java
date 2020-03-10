package leetCode.problems._304_Range_Sum_Query_2D_Immutable;

public class NumMatrix {
	private int[][] sumRegions;
    public NumMatrix(int[][] matrix) {
    	int[] lineSum = null;
    	if(matrix.length!=0) {
    		sumRegions = new int[matrix.length+1][matrix[0].length+1];
            lineSum = new int[matrix[0].length+1];
    	}
        
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < lineSum.length-1; j++) {
				lineSum[j+1]=lineSum[j]+matrix[i][j];
				sumRegions[i+1][j+1] = sumRegions[i][j+1]+lineSum[j+1];
			}
		}
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sumRegions[row2+1][col2+1]
        		-(sumRegions[row1][col2+1]-sumRegions[row1][col1])
        		-sumRegions[row2+1][col1];
    }
    public static void main(String[] args) {
    	
		NumMatrix numMatrix = new NumMatrix(new int[][] {{-4,-5}});
		System.out.println(numMatrix.sumRegion(0, 0, 0, 1));
	}
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
