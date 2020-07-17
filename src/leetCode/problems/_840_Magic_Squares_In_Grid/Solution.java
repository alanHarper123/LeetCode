package leetCode.problems._840_Magic_Squares_In_Grid;

public class Solution {
	 
    public int numMagicSquaresInside(int[][] grid) {
        int rowC = grid.length-1;
        int colC = grid[0].length-1;
        if(rowC<=1||colC<=1)
        	return 0;
        int sum = 0;
        for (int i = 1; i < rowC; i++) {
			for (int j = 1; j < colC; j++) {
				if(grid[i][j]==5) {
					if(!isNumsUnique(grid, i, j))
						continue;
					if(!judgeSum(grid, i, j))
						continue;
					sum+=1;
				}	
			}
		}
        return sum;
    }
    private boolean isNumsUnique(int[][] grid,int i, int j) {
    	boolean[] isUnique = new boolean[10];
    	for (int m = i-1; m < i+2; m++) {
			for (int n = j-1; n < j+2; n++) {
				int val = grid[m][n];
				if(val<1||val>9||isUnique[val])
					return false;
				isUnique[val] = true;
			}
		}
    	return true;
    }
    private boolean judgeSum(int[][] grid,int i, int j) {
    	for (int m = i-1; m < i+2; m++) {
			if(grid[m][j-1]+grid[m][j]+grid[m][j+1]!=15)
				return false;
		}
    	for (int n = j-1; n < j+2; n++) {
			if(grid[i-1][n]+grid[i][n]+grid[i+1][n]!=15)
				return false;
		}
    	if(grid[i-1][j-1]+grid[i+1][j+1]!=10)
    		return false;
    	if(grid[i+1][j-1]+grid[i-1][j+1]!=10)
    		return false;
    	return true;
    }
}
