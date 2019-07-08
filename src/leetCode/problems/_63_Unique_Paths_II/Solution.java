package leetCode.problems._63_Unique_Paths_II;

public class Solution {
//	This is a typical 2D DP problem, we can store value in 2D DP array, 
//	but since we only need to use value at dp[i - 1][j] and dp[i][j - 1] 
//	to update dp[i][j], we don't need to store the whole 2D table, 
//	but instead store value in an 1D array, and update data by 
//	using dp[j] = dp[j] + dp[j - 1], 
//	(where here dp[j] corresponding to the dp[i - 1][j]) and dp[j - 1]
//	corresponding to the dp[i][j - 1] in the 2D array)
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if(obstacleGrid.length==0) 
			return 0;
		int[] dp = new int[obstacleGrid[0].length];
		dp[0] = 1;
		for (int i = 0; i < obstacleGrid.length; i++) {
			for (int j = 0; j < dp.length; j++) {
				if(obstacleGrid[i][j]==1) {
					dp[j]=0;
				}else if (j>0) {
					dp[j]+=dp[j-1];
				}
			}
		}
		return dp[dp.length-1];
	}

	public static void main(String[] args) {
		int[][][] test = {
				{
					{0}
				},
				{
					{1}
				},
				{
					{0,0,0},
					{0,1,0},
					{0,0,0}
				},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[][] js = test[i];
			System.out.println(solution.uniquePathsWithObstacles(js));
		}
	}
}
