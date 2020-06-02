package leetCode.problems._611_Valid_Triangle_Number;

import java.util.Arrays;

public class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int totalNumber = 0;
        for (int i = 0; i < nums.length-2; i++) {
        	for (int j = i+1; j < nums.length-1; j++) {
        		totalNumber+=binarySearch(nums, nums[i]+nums[j], j)-j-1;
			}
		}
        return totalNumber;
    }
   // return the first index(larger than start) of element in nums 
    //that is larger or equal to target;
    private int binarySearch(int[] nums, int target, int start) {
    	while (true) {
    		int k = 1;
    		while (start+k<nums.length&&nums[start+k]<target) {
				start+=k;
				k<<=1;
			}
    		if(k==1)
    			return start+k;
		}
    }
}
