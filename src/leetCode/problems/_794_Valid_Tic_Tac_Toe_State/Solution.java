package leetCode.problems._794_Valid_Tic_Tac_Toe_State;

public class Solution {
	public boolean validTicTacToe(String[] board) {
		int xCount = 0;
		int oCount = 0;
		for (String row:board) {
			for (int i = 0; i < row.length(); i++) {
				if(row.charAt(i)=='X')
					xCount++;
				else if(row.charAt(i)=='O')
					oCount++;
			}
		}
		if(xCount-oCount>1||oCount>xCount)
			return false;
		boolean is_X_winner = isWinner('X', board);
		boolean is_O_winner = isWinner('O', board);
		if(is_O_winner&&is_X_winner)
			return false;
		if(is_O_winner&&xCount!=oCount)
			return false;
		if(is_X_winner&&xCount==oCount)
			return false;
		return true;

	}
	private boolean isWinner(char canditate,String[] board) {
		loop1:for (String row:board) {
			for (int i = 0; i < row.length(); i++) {
				if(row.charAt(i)!=canditate)
					continue loop1;
			}
			return true;
		}
		loop2:for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if(board[j].charAt(i)!=canditate)
					continue loop2;
			}
			return true;
		}
		boolean isWinner = true;
		for (int i = 0; i < 3; i++) {
			if(board[i].charAt(i)!=canditate) {
				isWinner = false;
				break;
			}	
		}
		if(isWinner)
			return true;
		isWinner = true;
		for (int i = 0; i < 3; i++) {
			if(board[i].charAt(2-i)!=canditate){
				isWinner = false;
				break;
			}
		}
		return isWinner;
	}
}
/*
A Tic-Tac-Toe board is given as a string array board. Return True if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.

The board is a 3 x 3 array, and consists of characters " ", "X", and "O".  The " " character represents an empty square.

Here are the rules of Tic-Tac-Toe:

    Players take turns placing characters into empty squares (" ").
    The first player always places "X" characters, while the second player always places "O" characters.
    "X" and "O" characters are always placed into empty squares, never filled ones.
    The game ends when there are 3 of the same (non-empty) character filling any row, column, or diagonal.
    The game also ends if all squares are non-empty.
    No more moves can be played if the game is over.

Example 1:
Input: board = ["O  ", "   ", "   "]
Output: false
Explanation: The first player always plays "X".

Example 2:
Input: board = ["XOX", " X ", "   "]
Output: false
Explanation: Players take turns making moves.

Example 3:
Input: board = ["XXX", "   ", "OOO"]
Output: false

Example 4:
Input: board = ["XOX", "O O", "XOX"]
Output: true

Note:

    board is a length-3 array of strings, where each string board[i] has length 3.
    Each board[i][j] is a character in the set {" ", "X", "O"}.

 */
