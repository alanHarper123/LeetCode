package leetCode.problems._419_Battleships_in_a_Board;

public class Solution {
    public int countBattleships(char[][] board) {
    	if(board==null||board.length==0||board[0].length==0)
    		return 0;
    	int row = board.length;
    	int col = board[0].length;
    	int count = 0;
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
				if(board[i][j]=='X') {
					count++;
                    int ic = 1;
					while (i+ic<row&&board[i+ic][j]=='X') {
						board[i+ic++][j]='M';
					}
					while (++j<col&&board[i][j]=='X') {
					}
					
				}
			}
		}
    	return count++;
    }
}
