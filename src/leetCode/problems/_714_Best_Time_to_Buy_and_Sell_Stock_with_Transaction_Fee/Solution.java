package leetCode.problems._714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee;

public class Solution {
    public int maxProfit(int[] prices, int fee) {
    	int profit = 0;
    	int buy = Integer.MAX_VALUE;
    	int high = Integer.MIN_VALUE;
    	int i = 0;
    	while (i+1<prices.length&&prices[i+1]<=prices[i]) {
			i++;
		}
        for (; i < prices.length;) {
			if(prices[i]<buy) {
				buy = prices[i];
				high=Integer.MIN_VALUE;
			}
			while (i+1<prices.length&&prices[i+1]>=prices[i]) {
				i++;
			}
			if (high<prices[i]) {
				high = prices[i];
			}
			i++;
			while (i+1<prices.length&&prices[i+1]<=prices[i]) {
				i++;
			}
			if(high-buy>=fee&&(i>=prices.length||high-prices[i]>fee)) {
				profit+=high-buy-fee;
				buy = Integer.MAX_VALUE;
		    	high = Integer.MIN_VALUE;
			}
		}
        return profit;
    }
    public static void main(String[] args) {
		int[] test = new int[] {2,2,3,1,3,2,1,4,4,3};
		System.out.println(new Solution().maxProfit(test, 4));
	}
}
