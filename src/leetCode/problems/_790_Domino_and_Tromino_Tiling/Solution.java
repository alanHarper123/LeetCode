package leetCode.problems._790_Domino_and_Tromino_Tiling;

public class Solution {
	private int mod = (int) (1e9+7);
    public int numTilings(int N) {
    	if(N==1)
    		return 1;
    	if(N==2)
    		return 2;
        int [] dp = new int[Math.max(N, 5)];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        // dp[i] = 2+dp[i-1]+dp[i-2]+2*sum(dp[0,i-3])), for i>=3;
        // can be simplified as dp[i] = 2*dp[i-1]+dp[i-3]; for i>=3;
        for (int i = 3; i < dp.length; i++) {
        	dp[i] += 2*dp[i-1];
        	dp[i] %= mod;
        	dp[i] += dp[i-3];
        	dp[i] %= mod;
		}
        return dp[N-1];
    }
}
