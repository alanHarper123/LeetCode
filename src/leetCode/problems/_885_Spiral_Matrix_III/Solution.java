package leetCode.problems._885_Spiral_Matrix_III;

public class Solution {
	int[][] dirs = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int count = 2;
        int len;
        int size = R*C;
        int diri = 0;
        int[] dir;
        int [][] res = new int[size][2];
        int r=r0,c=c0;
        int i=0;
        res[i][0] = r;
        res[i++][1] = c;
        while (i<size) {
			len = count>>1;
        	dir = dirs[diri];
        	if((dir[0]==0&&(r<0||r>=R))||(dir[1]==0&&(c<0||c>=C))) {
        		r+=len*dir[0];
        		c+=len*dir[1];
        	}else {
        		for (int j = 0; j < len; j++) {
    				r+=dir[0];
    				c+=dir[1];
    				if(r>=0&&r<R&&c>=0&&c<C) {
    					res[i][0] = r;
    			        res[i++][1] = c;
    				}
    			}
        	}
        	diri++;
        	if(diri==4)
        		diri = 0;
        	count++;
		}
        return res;
    }
}
/*
885. Spiral Matrix III
Medium

On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

Now, we walk in a clockwise spiral shape to visit every position in this grid. 

Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.) 

Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.

 

Example 1:

Input: R = 1, C = 4, r0 = 0, c0 = 0
Output: [[0,0],[0,1],[0,2],[0,3]]


 

Example 2:

Input: R = 5, C = 6, r0 = 1, c0 = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]


 

Note:

    1 <= R <= 100
    1 <= C <= 100
    0 <= r0 < R
    0 <= c0 < C
 */