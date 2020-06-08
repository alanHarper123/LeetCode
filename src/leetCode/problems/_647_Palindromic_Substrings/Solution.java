package leetCode.problems._647_Palindromic_Substrings;

public class Solution {
    public int countSubstrings(String s) {
    	int count = 0;
        for (int i = 0; i < s.length(); i++) {
			int l = 1;
			while(i+l<s.length()&&i-l>=0&&s.charAt(i+l)==s.charAt(i-l))
				l++;
			count+=l;
			if(i+1<s.length()&&s.charAt(i)==s.charAt(i+1)) {
				l = 1;
				while(i+1+l<s.length()&&i-l>=0&&s.charAt(i+1+l)==s.charAt(i-l))
					l++;
				count+=l;
			}
		}
        return count;
    }
}
