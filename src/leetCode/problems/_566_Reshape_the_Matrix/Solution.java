package leetCode.problems._566_Reshape_the_Matrix;

public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int oldr = nums.length;
        int oldc = nums[0].length;
        if(oldc*oldr!=r*c)
        	return nums;
        int[][] reshapedMatrix = new int[r][c];
        for (int i = 0,totalIndex=0; i < oldr; i++) {
			for (int j = 0; j < oldc; j++,totalIndex++) {
				reshapedMatrix[totalIndex/c][totalIndex%c] = nums[i][j];
			}
		}
        return reshapedMatrix;
        
    }
}
