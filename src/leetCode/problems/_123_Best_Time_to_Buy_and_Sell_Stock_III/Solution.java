package leetCode.problems._123_Best_Time_to_Buy_and_Sell_Stock_III;

public class Solution {
	public int maxProfit(int[] prices) {
		int buy1 =Integer.MAX_VALUE,sell1=0,
				buy2=Integer.MAX_VALUE,sell2=0;
		for (int i = 0; i < prices.length; i++) {
			buy1 = Math.min(prices[i], buy1);
			sell1 = Math.max(prices[i]-buy1, sell1);
			buy2 = Math.min(prices[i]-sell1, buy2);
			sell2 = Math.max(prices[i]-buy2, sell2);
		}
		return sell2;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] tests = {
				{1,3,5,4,3,7,6,9,2,4},
				{1,2,4,2,5,7,2,4,9,0},
				{9,9,0,3,0,7,7,7,4,1,5,0,1,7},
				{2,4,1,11,7},
				{5,2,3,0,3,5,6,8,1,5},			
				{6,1,3,2,4,7},
				{3,3,5,0,0,3,1,4},
				{1,2,3,4,5},
				{7,6,4,3,1}};
		for (int i = 0; i < tests.length; i++) {
			System.out.println(solution.maxProfit(tests[i]));
		}
	}
}
