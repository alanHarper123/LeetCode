package leetCode.problems._73_Set_Matrix_Zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
    	if (matrix.length==0) 
			return;
        boolean[] zeroRows = new boolean[matrix.length];
        boolean[] zeroColumns = new boolean[matrix[0].length];
        for (int i = 0; i < zeroRows.length; i++) {
			for (int j = 0; j < zeroColumns.length; j++) {
				if (matrix[i][j]==0) {
					zeroRows[i] = true;
					zeroColumns[j] = true;
				}	
			}
		}
        for (int i = 0; i < zeroRows.length; i++) {
			for (int j = 0; j < zeroColumns.length; j++) {
				if (zeroRows[i] == true||zeroColumns[j] == true) {
					matrix[i][j]=0;
				}	
			}
		}
    }
}
