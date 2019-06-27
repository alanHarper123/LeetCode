package leetCode.problems._34_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length==0) {
			return result;
		}
        int midIndex = Arrays.binarySearch(nums, target);
        if(midIndex>=0) {
        	int low = midIndex;
        	while (low>=1&&nums[low]==nums[low-1]) {
				int power = 1;
				while (low-power>=0&&nums[low]==nums[low-power]) {
					low = low-power;
					power<<=1;
				}
			}
        	int high = midIndex;
        	while (high<=nums.length-2&&nums[high]==nums[high+1]) {
				int power = 1;
				while (high+power<nums.length&&nums[high]==nums[high+power]) {
					high = high+power;
					power<<=1;
					
				}
			}
        	result[0] = low;
        	result[1] = high;
        }
        return result;
    }

}

