package leetCode.problems._816_Ambiguous_Coordinates;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> ambiguousCoordinates(String S) {
    	S = S.substring(1, S.length()-1);
        char[] chars = S.toCharArray();
        LinkedList<String> res = new LinkedList<>();
        for (int i = 1; i < chars.length; i++) {
			if(chars[0]=='0'&&i!=1&&chars[i-1]=='0'||
					(chars[i]=='0'&&i!=chars.length-1&&chars[chars.length-1]=='0')) {
				continue;
			}
			LinkedList<String> heads = getNum(chars, 0, i-1);
			LinkedList<String> tails = getNum(chars, i, chars.length-1);
			for(String head:heads) {
				for (String tail:tails) {
					res.add("("+head+", "+tail+")");
				}
			}
		}
        return res;
    }
    private LinkedList<String> getNum(char[] chars,int start,int end){
    	LinkedList<String> res = new LinkedList<>();
    	StringBuilder stringBuilder = new StringBuilder(String.valueOf(chars, start, end-start+1));
    	if(chars[start]=='0') {
    		if(end!=start) {
    			stringBuilder.insert(1, '.');
    		}
    		res.add(stringBuilder.toString());
    	}else if(chars[end]!='0') {
    		res.add(stringBuilder.toString());
    		for (int i = 1; i <= end-start; i++) {
				stringBuilder.insert(i, '.');
				res.add(stringBuilder.toString());
				stringBuilder.deleteCharAt(i);
			}
    	}else {
    		res.add(stringBuilder.toString());
    	}
    	return res;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.ambiguousCoordinates("(100)"));
	}
}
/*
816. Ambiguous Coordinates
Medium

We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points, and spaces, and ended up with the string S.  Return a list of strings representing all possibilities for what our original coordinates could have been.

Our original representation never had extraneous zeroes, so we never started with numbers like "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.  Also, a decimal point within a number never occurs without at least one digit occuring before it, so we never started with numbers like ".1".

The final answer list can be returned in any order.  Also note that all coordinates in the final answer have exactly one space between them (occurring after the comma.)

Example 1:
Input: "(123)"
Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]

Example 2:
Input: "(00011)"
Output:  ["(0.001, 1)", "(0, 0.011)"]
Explanation: 
0.0, 00, 0001 or 00.01 are not allowed.

Example 3:
Input: "(0123)"
Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]

Example 4:
Input: "(100)"
Output: [(10, 0)]
Explanation: 
1.0 is not allowed.

 

Note:

    4 <= S.length <= 12.
    S[0] = "(", S[S.length - 1] = ")", and the other elements in S are digits.
 */
