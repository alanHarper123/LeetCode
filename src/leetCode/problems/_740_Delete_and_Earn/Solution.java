package leetCode.problems._740_Delete_and_Earn;

import java.util.Arrays;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] numsSimplied = new int[nums.length];
        int[] numSums = new int[nums.length];
        int numSLen = 0;
        for (int i=0; i < nums.length; i++) {
			numsSimplied[numSLen] = nums[i];
			numSums[numSLen]=nums[i];
			while (i+1<nums.length&&nums[i+1]==nums[i]) {
				numSums[numSLen]+=nums[i++];
			}
			numSLen++;
		}
        int i = 0;
        int maxC = 0;
        int[] dp = new int[numSLen];
        while (i<numSLen) {
        	int j = i+1;
        	while (j < numSLen&&numsSimplied[j]-numsSimplied[j-1]==1) {
				j++;
			}
			maxC+=getMaxPoint(numsSimplied, i, j,dp,numSums);
			i=j;
		}
        return maxC;
    }
    private int getMaxPoint(int[] nums,int start,int end,int[] dp,int[] numSums) {
    	dp[start]=numSums[start];
    	if(start+1<end)
    		dp[start+1] = Math.max(dp[start], numSums[start+1]);
    	for (int i = start+2; i < end; i++) {
			dp[i] = Math.max(dp[i-1], dp[i-2]+numSums[i]);
		}
    	return dp[end-1];
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.deleteAndEarn(new int[] {10,8,4,2,1,3,4,8,2,9,10,4,8,5,9,1,5,1,6,
				8,1,1,6,7,8,9,1,7,6,8,4,5,4,1,5,9,8,6,10,6,
				4,3,8,4,10,8,8,10,6,4,4,4,9,6,9,10,7,1,5,3,
				4,4,8,1,1,2,1,4,1,1,4,9,4,7,1,5,1,10,3,5,10,
				3,10,2,1,10,4,1,1,4,1,2,10,9,7,10,1,2,7,5}));
	}
}
