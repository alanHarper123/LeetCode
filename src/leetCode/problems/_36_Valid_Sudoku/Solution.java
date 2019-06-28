package leetCode.problems._36_Valid_Sudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	//check for each row
    	
        for (int i = 0; i < board.length; i++) {
			char[] cs = board[i];
			char[] sudoku = {'1','2','3','4','5','6','7','8','9'};
			for (int j = 0; j < cs.length; j++) {
				char c = cs[j];
				if(c!='.') {
					if('0'<c&&c<='9'&&sudoku[Character.getNumericValue(c)-1]==c) {
						sudoku[Character.getNumericValue(c)-1] = '.';
					}else {
						return false;
					}
				}
			}			
		}
      //check for each column
        for (int i = 0; i < board.length; i++) {
			char[] sudoku = {'1','2','3','4','5','6','7','8','9'};
			
			for (int j = 0; j < board.length; j++) {
				char c = board[j][i];
				if(c!='.') {
					if('0'<c&&c<='9'&&sudoku[Character.getNumericValue(c)-1]==c) {
						sudoku[Character.getNumericValue(c)-1] = '.';
					}else {
						return false;
					}
				}
			}
		}
        
        //check for 9 sub-boxes
        for (int i = 0; i < 3; i++) {
        	for (int j = 0; j < 3; j++) {
        		char[] sudoku = {'1','2','3','4','5','6','7','8','9'};
        		for (int i2 = i*3; i2 < (i+1)*3; i2++) {
        			for (int j2 = j*3; j2 < (j+1)*3; j2++) {
        				char c = board[i2][j2];
        				if(c!='.') {
        					if('0'<c&&c<='9'&&sudoku[Character.getNumericValue(c)-1]==c) {
        						sudoku[Character.getNumericValue(c)-1] = '.';
        					}else {
        						return false;
        					}
        				}
					}
        		}
        	}
        }
        
        return true;
    }
}
