package leetCode.problems._695_Max_Area_of_Island;

public class Solution {
	private static int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {
    	int maxArea = 0;
    	if(grid!=null&&grid.length!=0) {
    		int rowC = grid.length;
    		int colC = grid[0].length;
    		for (int i = 0; i < rowC; i++) {
    			for (int j = 0; j < colC; j++) {
					if(grid[i][j]==1) {
						maxArea = Math.max(countArea(grid, i, j, rowC, colC), maxArea);
					}
				}
    		}
    	}
    	return maxArea;
        
    }
    private int countArea(int[][] grid,int i,int j,int rowC,int colC) {
    	int area = 1;
    	grid[i][j] = 2;
    	for (int[] dir:dirs) {
			int nexti = i+dir[0];
			int nextj = j+dir[1];
			if(nexti>=0&&nexti<rowC&&nextj>=0&&nextj<colC&&grid[nexti][nextj]==1) {
				area+=countArea(grid, nexti, nextj, rowC, colC);
			}
		}
    	return area;
    }
}
