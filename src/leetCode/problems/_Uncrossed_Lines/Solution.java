package leetCode.problems._Uncrossed_Lines;

public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
        int rowC = A.length+1;
        int colC = B.length+1;
        int[][] dp = new int[rowC][colC];
        for (int i = 1; i < rowC; i++) {
			for (int j = 1; j < colC; j++) {
				if(A[i-1]==B[j-1]) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
        return dp[rowC-1][colC-1];
    }
}
