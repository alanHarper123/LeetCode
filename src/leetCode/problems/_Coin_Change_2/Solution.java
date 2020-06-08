package leetCode.problems._Coin_Change_2;

import java.util.Arrays;

public class Solution {
    public int change(int amount, int[] coins) {
    	if(coins==null||coins.length==0)
    		return amount==0?1:0;
        int[][] coinChangeWays = new int[amount+1][coins.length+1];
        Arrays.fill(coinChangeWays[0], 1);
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
			for (int j = 1; j <= coins.length; j++) {
				coinChangeWays[i][j] += coinChangeWays[i][j-1];
				if(i-coins[j-1]>=0)
					coinChangeWays[i][j] += coinChangeWays[i-coins[j-1]][j];
			}
		}
        return coinChangeWays[amount][coins.length];
    }

    public static void main(String[] args) {
		int[] coins = new int[] {1,2,5};
		Solution solution = new Solution();
		System.out.println(solution.change(5, coins));
	}
}
