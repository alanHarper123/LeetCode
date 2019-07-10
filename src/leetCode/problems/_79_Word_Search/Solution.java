package leetCode.problems._79_Word_Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class Solution {
	public boolean exist(char[][] board, String word) {
		if (board.length==0||board[0].length==0) {
			return false;
		}
		// the best solution use board[i][j] ^= 0b100000000 to mark the visited cell
		LinkedHashSet<List<Integer>> filter = new LinkedHashSet<>(word.length());
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				backTrack(filter,board,word,i,j);
				if (filter.size()==word.length()) {
					return true;
				}
			}
		}
		return false;
	}
	private void backTrack(LinkedHashSet<List<Integer>>filter,
			char[][] board, String word, int startR, int startC) {
		ArrayList<Integer> currentL =new ArrayList<>(Arrays.asList(startR,startC)); 
		if(startR>=board.length||startR<0||startC>=board[0].length||startC<0||
				filter.contains(currentL))
			return;
		if(word.charAt(filter.size())
				!=board[startR][startC])
			return;

		filter.add(new ArrayList<>(Arrays.asList(startR,startC)));
		int[][] nextPositions = {
				{startR+1,startC},
				{startR-1,startC},
				{startR,startC+1},
				{startR,startC-1},
		};
		for (int i = 0; i < nextPositions.length; i++) {
			if(filter.size()!=word.length()) {
				backTrack(filter, board, word, nextPositions[i][0], nextPositions[i][1]);
			}
			else 
				return;
		}
		if(filter.size()!=word.length())
			filter.remove(currentL);
	}
	public static void main(String[] args) {
		char[][][]test = {
				{
					{'A','B','C','E'},
					{'S','F','C','S'},
					{'A','D','E','E'}
				},
				{
					{'a','b'},
				},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			char[][] js = test[i];
			System.out.println(solution.exist(js,"ABCCED"));
			System.out.println(solution.exist(js,"SEE"));
			System.out.println(solution.exist(js,"ABCB"));
			System.out.println(solution.exist(js,"ba"));
		}
	}
}
