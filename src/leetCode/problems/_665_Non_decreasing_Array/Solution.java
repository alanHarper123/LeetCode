package leetCode.problems._665_Non_decreasing_Array;

public class Solution {
    public boolean checkPossibility(int[] nums) {
    	int i = 1;
        for (; i < nums.length; i++) {
			if(nums[i]<nums[i-1]) {
				if(i==nums.length-1)
					return true;
				else {
					if(nums[i+1]<nums[i]) {
						if( nums[i-1]<=nums[i+1]) {
							i++;
							break;
						}else {
							return false;
						}
					}else if(i==1) {
						break;
					}else {
						if(nums[i-1]<=nums[i+1]||nums[i-2]<=nums[i]) {
							break;
						}else {
							return false;
						}
					}
				}
			}	
		}
        for (i++; i < nums.length; i++) {
        	if(nums[i]<nums[i-1])
        		return false;
		}
        return true;
    }
}
