package leetCode.problems._1138_Alphabet_Board_Path;

public class Solution {
    public String alphabetBoardPath(String target) {
        StringBuilder res = new StringBuilder();
        int ri = 0;
        int ci = 0;
        char p = 'a';
        for(char c:target.toCharArray()) {
        	if(p!=c){
        		int cur = c-'a';
        		int rci = cur/5;
        		int cui = cur%5;
        		char rc = cui>ci?'R':'L';
        		char cc = rci>ri?'D':'U';
        		int dif;
        		if(c=='z') {
        			dif = Math.abs(cui-ci);
            		while (dif>0) {
    					dif--;
    					res.append(rc);
    				}
            		dif = Math.abs(rci-ri);
        			while (dif>0) {
    					dif--;
    					res.append(cc);
            		}
        		}else {
        			dif = Math.abs(rci-ri);
        			while (dif>0) {
    					dif--;
    					res.append(cc);
            		}
            		dif = Math.abs(cui-ci);
            		while (dif>0) {
    					dif--;
    					res.append(rc);
    				}
        		}
        		
        		ri = rci;
        		ci = cui;
        		p = c;
        	}
        	res.append('!');
        }
        return res.toString();
    }
}
/*
1138. Alphabet Board Path
Medium

On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.

We may make the following moves:

    'U' moves our position up one row, if the position exists on the board;
    'D' moves our position down one row, if the position exists on the board;
    'L' moves our position left one column, if the position exists on the board;
    'R' moves our position right one column, if the position exists on the board;
    '!' adds the character board[r][c] at our current position (r, c) to the answer.

(Here, the only positions that exist on the board are positions with letters on them.)

Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  You may return any path that does so.
*/