package leetCode.problems._807_Max_Increase_to_Keep_City_Skyline;

public class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int rowC = grid.length;
        int colC = grid[0].length;
        int[] topOutline = new int[colC];
        int[] leftOutline = new int[rowC];
        for (int i = 0; i < rowC; i++) {
			for (int j = 0; j < colC; j++) {
				int val = grid[i][j];
				if(val>topOutline[j])
					topOutline[j] = val;
				if(val>leftOutline[i])
					leftOutline[i] = val;
			}
		}
        int sum = 0;
        for (int i = 0; i < rowC; i++) {
			for (int j = 0; j < colC; j++) {
				int bound = Math.min(topOutline[j], leftOutline[i]);
				sum+=bound-grid[i][j];
			}
		}
        return sum;
    }
}
