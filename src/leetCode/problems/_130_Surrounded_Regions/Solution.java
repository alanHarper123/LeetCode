package leetCode.problems._130_Surrounded_Regions;

public class Solution {
	private int m;
	private int n;
	public void solve(char[][] board) {
		m = board.length;
		if(m==0)
			return;
		n = board[0].length;
		if(n==0)
			return;
		for (int i = 0; i < m; i++) {
			if(board[i][0]=='O')
				mask(board,i,0);
			if(board[i][n-1]=='O')
				mask(board,i,n-1);
		}
		for (int j = 0; j < n; j++) {
			if(board[0][j]=='O')
				mask(board,0,j);
			if(board[m-1][j]=='O')
				mask(board,m-1,j);
		}
		for (int i = 0; i <m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j]=='O') 
					board[i][j]='X';
				else if (board[i][j]=='1') 
					board[i][j]='O';

			}
		}
	}
	//mask open area with char '1'
	private void mask(char[][] board,int r, int c) {
		board[r][c] = '1';
		if(r+1<m&&board[r+1][c]=='O')
			mask(board,r+1,c);
		if(r-1>-1&&board[r-1][c]=='O')
			mask(board,r-1,c);
		if(c+1<n&&board[r][c+1]=='O')
			mask(board,r,c+1);
		if(c-1>-1&&board[r][c-1]=='O')
			mask(board,r,c-1);
	}
}
