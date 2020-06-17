package leetCode.problems._688_Knight_Probability_in_Chessboard;

import java.util.Arrays;

public class Solution {
	private static int[][] dirs = new int[][] {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
    public double knightProbability(int N, int K, int r, int c) {
        double[][] dp = new double[N][N];
        double[][] dpC = new double[N][N];
        for(double[] dpR:dp) {
        	Arrays.fill(dpR, 1);
        }
        while (K>0) {
			K--;
			int nextPr;
			int nextPc;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					dpC[i][j]=0;
					for (int[] dir:dirs) {
						nextPr = i+dir[0];
						nextPc = j+dir[1];
						if(nextPc>=0&&nextPc<N&&nextPr>=0&&nextPr<N)
							dpC[i][j]+=dp[nextPr][nextPc]/8;
					}
				}
			}
			double[][] temp = dp;
			dp = dpC;
			dpC = temp;
		}
        return dp[r][c];
    }
}
