package leetCode.problems._832_Flipping_an_Image;

public class Solution {
	public int[][] flipAndInvertImage(int[][] A) {
		int rowC = A.length;
		int colC = A[0].length;
		for (int i = 0; i < rowC; i++) {
			int j = 0,k = colC-1;
			for (; j < k; j++,k--) {
				int temp = A[i][j];
				A[i][j] = 1-A[i][k];
				A[i][k] = 1-temp;
			}
			if(j==k)
				A[i][j] = 1-A[i][j];
		}
		return A;
	}
}
