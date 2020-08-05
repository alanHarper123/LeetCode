package leetCode.problems._912_Sort_an_Array;

public class Solution {
	private int offset = 50000;
    public int[] sortArray(int[] nums) {
        int[] buckets = new int[offset*2+1];
        for(int num:nums)
        	buckets[num+offset]++;
        for (int i = 0,m=0,ne; i < buckets.length; i++) {
        	ne = i-offset;
			for (int j = 0; j < buckets[i]; j++) {
				nums[m++] = ne;
			}
		}
        return nums;
    }
}
/*
912. Sort an Array
Medium

Given an array of integers nums, sort the array in ascending order.

 

Example 1:

Input: nums = [5,2,3,1]
Output: [1,2,3,5]

Example 2:

Input: nums = [5,1,1,2,0,0]
Output: [0,0,1,1,2,5]

 

Constraints:

    1 <= nums.length <= 50000
    -50000 <= nums[i] <= 50000
*/
