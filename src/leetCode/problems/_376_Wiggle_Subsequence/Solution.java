package leetCode.problems._376_Wiggle_Subsequence;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
    	if(nums==null||nums.length==0)
    		return 0;
        int count = 0;
        int i=0;
        while (i+1<nums.length) {
			if(nums[i+1]==nums[i])
				i++;
			else 
				break;
			
		}
        while (i+1<nums.length) {
        	count++;
			if(nums[i+1]>nums[i]) {
				while (i+1<nums.length&&nums[i+1]>=nums[i]) {
					i++;
				}
			}else {
				while (i+1<nums.length&&nums[i+1]<=nums[i]) {
					i++;
				}
			}
		}
        
        return ++count;
    }
}
