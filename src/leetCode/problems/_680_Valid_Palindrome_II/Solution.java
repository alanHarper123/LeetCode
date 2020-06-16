package leetCode.problems._680_Valid_Palindrome_II;

public class Solution {
    public boolean validPalindrome(String s) {
        int start = 0, end = s.length()-1;
        while (end>=start) {
			if(s.charAt(end)!=s.charAt(start))
				return checkIsvalidPalindrome(s, start+1, end)||checkIsvalidPalindrome(s, start, end-1);
			end--;
			start++;
		}
        return true;
    }
    private boolean checkIsvalidPalindrome(String s,int start,int end) {
    	while (end>=start) {
			if(s.charAt(end)!=s.charAt(start))
				return false;
			end--;
			start++;
		}
    	return true;
    }
}
/*
 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

Note:

    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 
 */
