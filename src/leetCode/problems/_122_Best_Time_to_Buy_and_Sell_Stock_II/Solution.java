package leetCode.problems._122_Best_Time_to_Buy_and_Sell_Stock_II;



public class Solution {
	public int maxProfit(int[] prices) {
		int maxProfits = 0;
		if(prices.length==0)
			return maxProfits;
		int buyPrice = prices[0];
		for (int i = 1; i < prices.length;) {
			if(prices[i]>=prices[i-1]) {
				while (i < prices.length&&prices[i]>=prices[i-1]) 
					i++;
				
				maxProfits += prices[i-1]-buyPrice;
			}else {
				while (i < prices.length&&prices[i]<prices[i-1]) 
					i++;

				buyPrice=prices[i-1];
			}
		}
		return maxProfits;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] tests = {{7,1,5,3,6,4},{1,2,3,4,5},{7,6,4,3,1}};
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.maxProfit(tests[i]));
		}
	}
}
