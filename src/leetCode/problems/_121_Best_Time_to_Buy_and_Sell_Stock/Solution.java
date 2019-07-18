package leetCode.problems._121_Best_Time_to_Buy_and_Sell_Stock;

public class Solution {
	public int maxProfit(int[] prices) {
		int maxProfit = 0;
		if(prices.length==0)
			return maxProfit;
		int buyPrice = prices[0];
		for (int i = 1; i < prices.length;) {
			if(prices[i]>=prices[i-1]) {
				while (i < prices.length&&prices[i]>=prices[i-1]) 
					i++;
				if(prices[i-1]-buyPrice>maxProfit)
					maxProfit = prices[i-1]-buyPrice;
			}else {
				while (i < prices.length&&prices[i]<prices[i-1]) 
					i++;
				if(prices[i-1]<buyPrice)
					buyPrice=prices[i-1];
			}
		}
		return maxProfit;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] tests = {{7,1,5,3,6,4},{7,6,4,3,1}};
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.maxProfit(tests[i]));
		}
	}
}
