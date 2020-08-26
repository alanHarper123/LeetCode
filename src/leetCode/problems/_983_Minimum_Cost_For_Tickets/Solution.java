package leetCode.problems._983_Minimum_Cost_For_Tickets;

public class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[][] costDp = new int[days.length][days.length];
        return getCost(costDp, days, costs, 0, days.length-1);
    }
    private int getCost (int[][] costDp,int[] days, int[] costs,int i, int j) {
    	int minC = costDp[i][j];
    	
    	if(minC==0) {
    		int cost = costs[0],ki=i,di=days[i];
    		if(i+1<=j)
    			cost+=getCost(costDp, days, costs, i+1, j);
    		minC = cost;
    		cost = costs[1];
    		while (ki<=j&&days[ki]<di+7) {
				ki++;
			}
    		if(ki<=j)
    			cost+=getCost(costDp, days, costs, ki, j);
    		if(cost<minC)
    			minC = cost;
    		cost = costs[2];
    		while (ki<=j&&days[ki]<di+30) {
				ki++;
			}
    		if(ki<=j)
    			cost+=getCost(costDp, days, costs, ki, j);
    		if(cost<minC)
    			minC = cost;
    		costDp[i][j] = minC;
    	}
    	return minC;
    }
}
/*
983. Minimum Cost For Tickets
Medium

In a country popular for train travel, you have planned some train travelling one year in advance.  The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

    a 1-day pass is sold for costs[0] dollars;
    a 7-day pass is sold for costs[1] dollars;
    a 30-day pass is sold for costs[2] dollars.

The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.

 

Note:

    1 <= days.length <= 365
    1 <= days[i] <= 365
    days is in strictly increasing order.
    costs.length == 3
    1 <= costs[i] <= 1000
 */