package leetCode.problems._784_Letter_Case_Permutation;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<String> letterCasePermutation(String S) {
		LinkedList<String> result = new LinkedList<>();
		char[] oleChars = S.toCharArray();
		char[] newChars = new char[S.length()];
		backTrack(result,oleChars, 0, newChars);
		return result;
	}
	private void backTrack(LinkedList<String> result,
			char[] oleChars, int k, char[] newChars) {
		if(k==newChars.length) {
			result.add(String.valueOf(newChars));
			return;
		}
		char c = oleChars[k];
		if(c>='a'&&c<='z') {
			newChars[k] = Character.toUpperCase(c);
			backTrack(result, oleChars, k+1, newChars);
		}else if(c>='A'&&c<='Z') {
			newChars[k] = Character.toLowerCase(c);
			backTrack(result, oleChars, k+1, newChars);
		}
		newChars[k] = c;
		backTrack(result, oleChars, k+1, newChars);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.letterCasePermutation("a1b2"));
	}
}
/*
784. Letter Case Permutation
Easy

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]

Note:

    S will be a string with length between 1 and 12.
    S will consist only of letters or digits.
 */
