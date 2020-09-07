package leetCode.problems._1025_Divisor_Game;

public class Solution {
    public boolean divisorGame(int N) {
        boolean[] dp = new boolean[N+1];
        int k = 2;
        while (k<=N) {
        	int root = (int) Math.sqrt(k);
        	if(!dp[k-1]) 
				dp[k] = true;
        	else {
        		for (int i = 2; i <= root; i++) {
    				if(k%i==0) {
    					if(!dp[k-i]) {
    						dp[k] = true;
    						break;
    					}
    					if(!dp[k-k/i]) {
    						dp[k] = true;
    						break;
    					}	
    				}
    			}
        	}
			k++;
		}
        return dp[N];
    }
}
