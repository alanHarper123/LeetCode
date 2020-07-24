package leetCode.problems._867_Transpose_Matrix;

public class Solution {
    public int[][] transpose(int[][] A) {
        int rowC = A.length;
        int colC = A[0].length;
        int [][] trans = new int[colC][rowC];
        for (int i = 0; i < rowC; i++) {
			for (int j = 0; j < colC; j++) {
				trans[j][i] = A[i][j];
			}
		}
        return trans;
    }
}
