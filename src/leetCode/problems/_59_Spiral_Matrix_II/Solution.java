package leetCode.problems._59_Spiral_Matrix_II;

import java.util.Arrays;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int roundsN = n%2+n/2;
        int index = 1;
        int j;
        for (int i = 0; i < roundsN; i++) {
        	if(2*i==n-1) {
				result[i][i]=index++;
				break;
			}
			for(j=i;j<n-1-i;j++) {
				result[i][j]=index++;
			}
			for (j = i; j <n-1-i; j++) {
				result[j][n-1-i]=index++;
			}
			for (j = n-1-i; j > i; j--) {
				result[n-1-i][j]=index++;
			}
			for (j= n-1-i; j > i; j--) {
				result[j][i]=index++;
			}
		}
        return result;
    }
    public static void main(String[] args) {
		int[] test = {3};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			System.out.println(Arrays.deepToString(solution.generateMatrix(test[i])));
		}
	}
}
