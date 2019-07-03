package leetCode.problems._48_Rotate_Image;

import java.util.Arrays;

class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length/2; i++) {
			for(int j=i;j<matrix.length-i-1;j++) {
				int temp = matrix[i][j];
				matrix[i][j]=matrix[j][matrix.length-1-i];
				matrix[j][matrix.length-1-i] = temp;
				temp = matrix[matrix.length-1-i][matrix.length-1-j];
				matrix[matrix.length-1-i][matrix.length-1-j] = matrix[matrix.length-1-j][i];
				matrix[matrix.length-1-j][i] = temp;
				temp = matrix[i][j];
				matrix[i][j] = matrix[matrix.length-1-i][matrix.length-1-j];
				matrix[matrix.length-1-i][matrix.length-1-j] = temp;
				
			}
			
		}
    }
    public static void main(String[] args) {
		int[][] test = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		new Solution().rotate(test);
		System.out.println(Arrays.deepToString(test));
	}
}