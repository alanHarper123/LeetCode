package leetCode.problems._1027_Longest_Arithmetic_Subsequence;

import java.util.HashMap;

public class Solution {
    public int longestArithSeqLength(int[] A) {
    	HashMap<Integer, Integer>[] dp = new HashMap[A.length];
    	for (int i = 0; i < dp.length; i++) {
			dp[i] = new HashMap<>();
		}
    	int max = 0;
    	for (int i = 1, val; i < dp.length; i++) {
    		val = A[i];
			for (int j = i-1; j >=0; j--) {
				int dif = val - A[j];
				int count = dp[j].getOrDefault(dif, 1);
				count++;
				if(count>max)
					max = count;
				dp[i].put(dif, Math.max(dp[i].getOrDefault(dif, 1), count));
			}
		}
    	return max;
    }
}
