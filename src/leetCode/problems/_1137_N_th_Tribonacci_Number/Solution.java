package leetCode.problems._1137_N_th_Tribonacci_Number;

public class Solution {
	int[] dp = new int[38];
    public Solution() {
    	dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
    		dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
    	}
	}
    public int tribonacci(int n) {
        return dp[n];
    }
}
