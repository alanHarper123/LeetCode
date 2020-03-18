package leetCode.problems._322_Coin_Change;

public class Solution {
	private Integer[] minCoinCInAmount;
    public int coinChange(int[] coins, int amount) {
        minCoinCInAmount = new Integer[amount+1];
        minCoinCInAmount[0]=0;
        int result = coinChangeUtil(coins, amount);
        return result==Integer.MAX_VALUE?-1:result;
    }
    private int coinChangeUtil(int[] coins, int amount) {
    	if(minCoinCInAmount[amount]!=null)
    		return minCoinCInAmount[amount];
    	int minC=Integer.MAX_VALUE;
    	for (int i = 0; i < coins.length; i++) {
    		if(amount-coins[i]>=0) {
    			int a = coinChangeUtil(coins, amount-coins[i]);
        		if(a!=Integer.MAX_VALUE&&minC>a+1)
        			minC = a+1;
    		}
		}
    	minCoinCInAmount[amount] = minC;
    	return minC;
    }
}
