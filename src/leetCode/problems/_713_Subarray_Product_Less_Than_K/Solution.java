package leetCode.problems._713_Subarray_Product_Less_Than_K;

public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int count = 0;
        int multi = 1;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]>=k) {
				start = i+1;
				multi = 1;
			}else {
				while (multi*nums[i]>=k) {
					multi/=nums[start++];
				}
				multi*=nums[i];
				count+=i-start+1;
			}	
		}
        return count;
    }
}
