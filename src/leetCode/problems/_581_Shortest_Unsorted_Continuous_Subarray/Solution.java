package leetCode.problems._581_Shortest_Unsorted_Continuous_Subarray;

import java.util.Arrays;

public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int begin = -1;
        for (int i = 0; i < numsCopy.length; i++) {
			if(nums[i]!=numsCopy[i]) {
				begin = i;
				break;
			}
		}
        if(begin==-1)
        	return 0;
        int end=0;
        for (int i = numsCopy.length-1; i >=0; i--) {
        	if(nums[i]!=numsCopy[i]) {
				end = i+1;
				break;
			}
		}
        return end-begin;
    }
}
