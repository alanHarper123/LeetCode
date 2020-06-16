package leetCode.problems._674._Longest_Continuous_Increasing_Subsequence;

public class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0)
        	return 0;
        int maxL = 1;
        for (int i = 0; i < nums.length; i++) {
			int count=1;
			while (i+1<nums.length&&nums[i+1]>nums[i]) {
				i++;
				count++;
			}
			if(count>maxL)
				maxL = count;
		}
        return maxL;
    }
}
