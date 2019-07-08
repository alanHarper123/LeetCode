package leetCode.problems._64_Minimum_Path_Sum;


public class Solution {
	public int minPathSum(int[][] grid) {
		int[] minSums = new int[grid[0].length];
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < minSums.length; j++) {
				if(j==0)
					minSums[j]+=grid[i][j];
				else if(i==0)
					minSums[j] = grid[i][j]+minSums[j-1];
				else 
					minSums[j] = grid[i][j]+Math.min(minSums[j-1], minSums[j]);				
			}
		}
		return minSums[minSums.length-1];
	}
	public static void main(String[] args) {
		int[][][] test = {
				{
					{1,3,1},
					{1,5,1},
					{4,2,1}
				},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[][] js = test[i];
			System.out.println(solution.minPathSum(js));
		}
	}
}
