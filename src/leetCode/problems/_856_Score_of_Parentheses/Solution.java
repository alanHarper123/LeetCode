package leetCode.problems._856_Score_of_Parentheses;

public class Solution {
    public int scoreOfParentheses(String S) {
        char[] chars = S.toCharArray();
        return cal(chars, 0, chars.length);
    }
    private int cal(char[] chars, int start, int end) {
    	if(end-start==1)
    		return 1;
    	int leftC = 1;
    	int sum = 0;
    	int begin = start;
    	for (int i = start+1; i < end; i++) {
			if(chars[i]=='(')
				leftC++;
			else {
				leftC--;
				if(leftC==0) {
					if(i-begin>1)
						sum+=2*cal(chars, begin+1, i);
					else 
						sum++;
					begin = i+1;
				}
			}
		}
    	return sum;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().scoreOfParentheses("(()(()))"));
	}
}
/*
856. Score of Parentheses
Medium

Given a balanced parentheses string S, compute the score of the string based on the following rule:

    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

 

Example 1:

Input: "()"
Output: 1

Example 2:

Input: "(())"
Output: 2

Example 3:

Input: "()()"
Output: 2

Example 4:

Input: "(()(()))"
Output: 6

 

Note:

    S is a balanced parentheses string, containing only ( and ).
    2 <= S.length <= 50
 */