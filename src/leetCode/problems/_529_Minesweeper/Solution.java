package leetCode.problems._529_Minesweeper;

public class Solution {
	int[][] dirs = new int[][] {{1,0},{1,1},{0,1},{-1,1},{-1,0},{-1,-1},{0,-1},{1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]]=='M') {
        	board[click[0]][click[1]]='X';
        }else if(board[click[0]][click[1]]=='E') {
        	sweep(board, click);
        }
        return board;
    }
    private void sweep(char[][] board, int[] click) {
    	int mineCount = 0;
    	for (int[] dir:dirs) {
    		click[0]+=dir[0];
    		click[1]+=dir[1];
			if(click[0]>=0&&click[0]<board.length&&
					click[1]>=0&&click[1]<board[0].length
					&&board[click[0]][click[1]]=='M')
				mineCount++;
			click[0]-=dir[0];
    		click[1]-=dir[1];
		}
    	if(mineCount == 0) {
    		board[click[0]][click[1]] = 'B';
    		for (int[] dir:dirs) {
        		click[0]+=dir[0];
        		click[1]+=dir[1];
    			if(click[0]>=0&&click[0]<board.length&&
    					click[1]>=0&&click[1]<board[0].length
    					&&board[click[0]][click[1]]=='E')
    				sweep(board, click);
    			click[0]-=dir[0];
        		click[1]-=dir[1];
    		}
    	}else {
    		board[click[0]][click[1]] = (char) ('0'+mineCount);
    	}
    }
}
