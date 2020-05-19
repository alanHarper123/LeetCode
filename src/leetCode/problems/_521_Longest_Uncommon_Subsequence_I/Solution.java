package leetCode.problems._521_Longest_Uncommon_Subsequence_I;

public class Solution {
	public int findLUSlength(String a, String b) {
		if(a.length()!=b.length())
			return Math.max(a.length(), b.length());
		for (int i = 0; i < b.length(); i++) {
			if(a.charAt(i)!=b.charAt(i))
				return a.length();
		}
		return -1;
	}
}
