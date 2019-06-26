package leetCode.problems.Three_Sum_Closest_16;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
        int result =target - nums[0]-nums[1]-nums[2];

        for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length-1; j++) {
				int temp = target - nums[i]-nums[j];
				if(temp<nums[j]) {
					break;
				}
				if(temp>=nums[nums.length-1]) {
					temp = temp - nums[nums.length-1];
					if(Math.abs(temp)<Math.abs(result)) {
						result = temp;
					}
					continue;
				}if(temp<nums[j+1]) {
					temp = temp - nums[j+1];
					if(Math.abs(temp)<Math.abs(result)) {
						result = temp;
					}
					break;
				}
				int b1 = j+1, e1 = nums.length;
				while (e1-b1>1) {
					int mid = (e1+b1)/2;
					if(temp>nums[mid]) {
						b1=mid;
					}else if (temp<nums[mid]) {
						e1 = mid;
					}else {
						return target;
					}
				}
				int min;
				if(temp-nums[b1]<nums[e1]-temp) {
					min = b1;
				}else {
					min = e1;
				}
				temp = temp-nums[min];
				if(Math.abs(temp)<Math.abs(result)) {
					result = temp;
				}
				
//				for (int k = j+1; k < nums.length; k++) {
//					int temp = nums[i]+nums[j]+nums[k]-target;
//					if(Math.abs(temp)<Math.abs(result)) {
//						result = temp;
//					}
//					
//				}
				
			}
			
		}
        return target - result;
    }
   
}
