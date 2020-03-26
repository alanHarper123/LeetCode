package leetCode.problems._344_Reverse_String;

public class Solution {
    public void reverseString(char[] s) {
        char temp;
        for (int i = 0; i <= s.length/2; i++) {
        	temp = s[i];
        	s[i] = s[s.length-i];
        	s[s.length-i] = temp;
		}
    }
}
