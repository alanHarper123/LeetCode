package leetCode.problems._1020_Number_of_Enclaves;

public class Solution {
	int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	int row;
	int col;
    public int numEnclaves(int[][] A) {
        row = A.length;
        col = A[0].length;
        for (int i = 0; i < row; i++) {
			if(A[i][0]==1)
				visitLand(A, i, 0);
			if(A[i][col-1]==1)
				visitLand(A, i, col-1);
		}
        for (int j = 0; j < col; j++) {
			if(A[0][j]==1)
				visitLand(A, 0, j);
			if(A[row-1][j]==1)
				visitLand(A, row-1, j);
		}
        int count=0;
        for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				count+=A[i][j];
			}
		}
        return count;
    }
    private void visitLand(int[][] A,int i,int j) {
    	A[i][j] = 0;
    	for(int[] dir:dirs) {
    		int ni = dir[0]+i;
    		int nj = dir[1]+j;
    		if(ni>=0&&ni<row&&nj>=0&&nj<col&&A[ni][nj]==1) {
    			visitLand(A, ni, nj);
    		}
    	}
    }
}
/*
1020. Number of Enclaves
Medium

Given a 2D array A, each cell is 0 (representing sea) or 1 (representing land)

A move consists of walking from one land square 4-directionally to another land square, or off the boundary of the grid.

Return the number of land squares in the grid for which we cannot walk off the boundary of the grid in any number of moves.

 

Example 1:

Input: [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: 
There are three 1s that are enclosed by 0s, and one 1 that isn't enclosed because its on the boundary.

Example 2:

Input: [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: 
All 1s are either on the boundary or can reach the boundary.

 

Note:

    1 <= A.length <= 500
    1 <= A[i].length <= 500
    0 <= A[i][j] <= 1
    All rows have the same size.
 */