package leetCode.problems._200_Number_of_Islands;

public class Solution {
	private int m;
	private int n;
    public int numIslands(char[][] grid) {
		m = grid.length;
		if(m==0)
			return 0;
		n = grid[0].length;
		if(n==0)
			return 0;
		int count=0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(grid[i][j]=='1') {
					mask(grid, i, j);
					count++;
				}		
			}
		}
		return count;
    }
	//mask visited island with char '2'
	private void mask(char[][] board,int r, int c) {
		board[r][c] = '2';
		if(r+1<m&&board[r+1][c]=='1')
			mask(board,r+1,c);
		if(r-1>-1&&board[r-1][c]=='1')
			mask(board,r-1,c);
		if(c+1<n&&board[r][c+1]=='1')
			mask(board,r,c+1);
		if(c-1>-1&&board[r][c-1]=='1')
			mask(board,r,c-1);
	}
}
