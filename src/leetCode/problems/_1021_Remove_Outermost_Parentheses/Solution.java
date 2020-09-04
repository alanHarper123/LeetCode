package leetCode.problems._1021_Remove_Outermost_Parentheses;

public class Solution {
    public String removeOuterParentheses(String S) {
        int leftCount = 0;
        StringBuilder res = new StringBuilder();
        char c;
        for (int i = 0; i < S.length(); i++) {
			c = S.charAt(i);
			if(c=='(') {
				leftCount++;
				if(leftCount!=1)
					res.append(c);
			}else {
				leftCount--;
				if(leftCount!=0)
					res.append(c);
			}
		}
        return res.toString();
    }
}
