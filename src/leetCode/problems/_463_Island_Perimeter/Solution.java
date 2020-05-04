package leetCode.problems._463_Island_Perimeter;

import java.util.LinkedList;

public class Solution {
	private int count;
	private int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int islandPerimeter(int[][] grid) {
    	count=0;
        loop1:for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if(grid[i][j]==1) {
					findIslandPerimeter(grid, i, j, grid.length, grid[0].length);
					break loop1;
				}
					
			}
		}
    	return count;
    }
    private void findIslandPerimeter(int[][] grid,int i, int j,int rowC,int colC) {

    	count +=4;
    	grid[i][j]=2;
    	for(int[] dir:dirs) {
    		int rowi = i+dir[0];
    		int coli = j+dir[1];
    		if(rowi<rowC&&rowi>=0&&coli<colC&&coli>=0) {
    			if(grid[rowi][coli]==1) {
                    count-=1;
                    findIslandPerimeter(grid, rowi, coli, rowC, colC);
    			}else if(grid[rowi][coli]==2) {
    				count-=1;
    			}
    		}
    	}
    }
    public static void main(String[] args) {
		int[][] test = new int[][] {{1,1},{1,1}};
		Solution solution = new Solution();
		System.out.println(solution.islandPerimeter(test));
	}
}
