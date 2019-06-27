package leetCode.problems._Next_Permutation_31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
    	int clargest = nums.length-1;
    	for (int i = nums.length-1; i > 0; i--) {
    		if(nums[clargest]<nums[i]) {
    			clargest = i;
    		}
			if(nums[clargest]>nums[i-1]) {
				Arrays.sort(nums, i, nums.length);
				for (int j = i; j < nums.length; j++) {
					if(nums[i-1]<nums[j]) {
						int temp = nums[i-1];
						nums[i-1]=nums[j];
						nums[j]=temp;
						return;
					}
				}
			}
		}
    	Arrays.sort(nums, 0, nums.length);
    }
}
