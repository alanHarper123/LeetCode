package leetCode.problems._746_Min_Cost_Climbing_Stairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
    	int[] minCosts = new int[cost.length+1];
        for (int i = 2; i < minCosts.length; i++) {
			minCosts[i] = Math.min(cost[i-1]+minCosts[i-1], cost[i-2]+minCosts[i-2]);
		}
        return minCosts[minCosts.length-1];
    }
}
