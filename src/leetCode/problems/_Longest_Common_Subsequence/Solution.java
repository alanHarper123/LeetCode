package leetCode.problems._Longest_Common_Subsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
    	if(text1==null||text2==null)
    		return 0;
        int[][] lcs = new int[text1.length()+1][text2.length()+1];
        for (int i = 1; i < lcs.length; i++) {
			for (int j = 1; j < lcs[0].length; j++) {
				if(text1.charAt(i-1)==text2.charAt(j-1))
					lcs[i][j]=lcs[i-1][j-1]+1;
				else 
					lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
			}
		}
        return lcs[text1.length()][text2.length()]; 
    }
}
