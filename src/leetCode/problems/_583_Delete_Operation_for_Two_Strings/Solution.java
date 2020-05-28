package leetCode.problems._583_Delete_Operation_for_Two_Strings;

public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1==null&&word2==null)
        	return 0;
        if(word1==null||word1.length()==0)
        	return word2.length();
        if(word2==null||word2.length()==0)
        	return word1.length();
        int r = word1.length()+1;
        int c = word2.length()+1;
        int[][] dp = new int[r][c];
        for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if(word1.charAt(i-1)==word2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
				}
			}
		}
        return r+c-2-2*dp[r-1][c-1];
    }
}
