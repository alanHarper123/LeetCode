package leetCode.problems._Maximal_Square;

public class Solution {
    public int maximalSquare(char[][] matrix) {
    	if(matrix==null||matrix.length==0||matrix[0].length==0)
    		return 0;
    	int row = matrix.length;
    	int col = matrix[0].length;
        int[][] dp = new int[row+1][col+1];
        int maxL = 0;
        for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if(matrix[i-1][j-1]=='0')
					dp[i][j]=0;
				else {
					int max = Math.min(dp[i-1][j-1], dp[i-1][j]);
					max = Math.min(max, dp[i][j-1]);
					dp[i][j]=++max;
					if(maxL<max)
						maxL = max;
				}
			}
		}
        return maxL*maxL;
    }
}
