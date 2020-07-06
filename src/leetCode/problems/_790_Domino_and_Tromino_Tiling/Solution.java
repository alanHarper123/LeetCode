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
/*
790. Domino and Tromino Tiling
Medium

We have two types of tiles: a 2x1 domino shape, and an "L" tromino shape. These shapes may be rotated.

XX  <- domino

XX  <- "L" tromino
X

Given N, how many ways are there to tile a 2 x N board? Return your answer modulo 10^9 + 7.

(In a tiling, every square must be covered by a tile. Two tilings are different if and only if there are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares occupied by a tile.)

Example:
Input: 3
Output: 5
Explanation: 
The five different ways are listed below, different letters indicates different tiles:
XYZ XXZ XYY XXY XYY
XYZ YYZ XZZ XYY XXY

Note:

    N  will be in range [1, 1000].
*/