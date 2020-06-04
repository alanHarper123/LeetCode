package leetCode.problems._Two_City_Scheduling;

import java.util.Arrays;

public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (c1,c2)->{
        	return c1[1]-c1[0]-(c2[1]-c2[0]);
        });
        int mid = costs.length/2;
        int minC=0;
        for (int i = 0; i <mid ; i++) {
        	minC+=costs[i][1];
		}
        for (int i =mid; i < costs.length; i++) {
        	minC+=costs[i][0];
		}
        return minC;
    }
}
