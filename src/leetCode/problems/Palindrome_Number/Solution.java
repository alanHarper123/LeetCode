package leetCode.problems.Palindrome_Number;

public class Solution {
	public boolean isPalindrome(int x) {

		if(x<0) {
			return false;
		}

		char[] chars = String.valueOf(x).toCharArray();
		for(int i = chars.length-1, j=0;i>-1;i--,j++ ) {      
			if(chars[j]!=chars[i]) {
				return false;
			}
		}
		return true;
	}
}
