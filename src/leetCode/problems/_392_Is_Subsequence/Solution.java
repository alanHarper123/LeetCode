package leetCode.problems._392_Is_Subsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
    	int start = 0;
        for (int i = 0; i < s.length(); i++) {
        	start = t.indexOf(s.charAt(i), start);
			if(start==-1)
				return false;
			start++;
		}
        return true;
    }
}
