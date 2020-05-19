package leetCode.problems._523_Continuous_Subarray_Sum;

import java.util.Arrays;

public class Solution {
	public boolean checkSubarraySum(int[] nums, int k) {
		if(nums==null)
			return false;
		int len = 2;
		int[] sums = Arrays.copyOf(nums, nums.length);
		for (; len <= nums.length; len++) {
			for (int i = 0; i+len <= nums.length; i++) {
				sums[i]+=nums[i+len-1];
				if((k!=0&&sums[i]%k==0)||(k==0&&sums[i]==0))
					return true;
			}
		}
		return false;
	}

}
