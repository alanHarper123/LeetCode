package leetCode.problems._799_Champagne_Tower;

import java.util.Arrays;


public class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][];
        for (int i = 0; i < dp.length; i++) {
			dp[i] = new double[i+1];
			Arrays.fill(dp[i], -1);
		}
        dp[0][0] = poured;
        return Math.min(getContent(dp, query_row, query_glass),1);
    }
    private double getContent(double[][] dp, int query_row, int query_glass) {
    	if(query_glass>query_row/2)
    		query_glass = query_row/2 - (query_glass - query_row/2)+
    		((query_row+1)%2==0?1:0);
    	if(dp[query_row][query_glass]==-1) {
    		dp[query_row][query_glass] = 0;
    		if(query_glass!=0)
    			dp[query_row][query_glass]+=
    			(Math.max(getContent(dp, query_row-1, query_glass-1)-1, 0))/2;
    		dp[query_row][query_glass]+=
    				(Math.max(getContent(dp, query_row-1, query_glass)-1, 0))/2;
    	}
    	return dp[query_row][query_glass];
    }
    double champagneTower002(int poured, int query_row, int query_glass) {
        double[][] dp = new double[query_row+1][];
        for (int i = 0; i < dp.length; i++) {
			dp[i] = new double[i+1];
		}
        dp[0][0] = poured;
        if(query_glass>query_row/2)
    		query_glass = query_row/2 - (query_glass - query_row/2)+
    		((query_row+1)%2==0?1:0);
        for (int i = 1; i <= query_row; i++) {
			for (int j = 0; j <= i/2; j++) {
				if(j!=0)
					dp[i][j] = Math.max(dp[i-1][j-1]-1,0)/2;
				if(j==i/2&&i%2==0) {			
						dp[i][j]*=2;
				}else 
					dp[i][j] += Math.max(dp[i-1][j]-1,0)/2;
			}
		}
        return Math.min(dp[query_row][query_glass],1);
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.champagneTower002(200, 15, 11));
	}
}
