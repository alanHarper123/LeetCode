package leetCode.problems._826_Most_Profit_Assigning_Work;

import java.util.Arrays;

public class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    	sortDifficulty(difficulty, profit, 0, difficulty.length);
        int sum = 0;
        int preIndex = 0;
        int profile = 0;
        Arrays.sort(worker);
        for (int i = 0; i < worker.length; i++) {
			int val = worker[i];
			while (preIndex<difficulty.length&&val>=difficulty[preIndex]) {
				profile = Math.max(profile, profit[preIndex]);
				preIndex++;
			}
			sum+=profile;
		}
        return sum;
    }
    private void sortDifficulty(int[] difficulty, int[] profit,int start,int end) {
    	if(end-start<=1)
    		return;
    	int mid = (end+start)/2;
    	sortDifficulty(difficulty, profit, start, mid);
    	sortDifficulty(difficulty, profit, mid, end);
    	int[] dif1 = Arrays.copyOfRange(difficulty, start, mid);
    	int[] pfoF1 = Arrays.copyOfRange(profit, start, mid);
    	int[] dif2 = Arrays.copyOfRange(difficulty, mid, end);
    	int[] pfoF2 = Arrays.copyOfRange(profit, mid, end);
    	int d1 = 0, d2 = 0;
    	while (d1<dif1.length&&d2<dif2.length) {
			if(dif1[d1]>dif2[d2]) {
				difficulty[start] = dif2[d2];
				profit[start++] = pfoF2[d2++];
			}else {
				difficulty[start] = dif1[d1];
				profit[start++] = pfoF1[d1++];
			}
		}
    	while (d1<dif1.length) {
    		difficulty[start] = dif1[d1];
			profit[start++] = pfoF1[d1++];
		}
    	while (d2<dif2.length) {
			difficulty[start] = dif2[d2];
			profit[start++] = pfoF2[d2++];
		}
    }
}
/*
826. Most Profit Assigning Work
Medium

We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job. 

Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with difficulty at most worker[i]. 

Every worker can be assigned at most one job, but one job can be completed multiple times.

For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot complete any job, his profit is $0.

What is the most profit we can make?

Example 1:

Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
Output: 100 
Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.

Notes:

    1 <= difficulty.length = profit.length <= 10000
    1 <= worker.length <= 10000
    difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
 */