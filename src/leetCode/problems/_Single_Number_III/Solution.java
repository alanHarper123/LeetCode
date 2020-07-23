package leetCode.problems._Single_Number_III;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
			xor^=nums[i];
		}
        int k = 1;
        while ((xor&k)!=k) {
			k<<=1;
		}
        int firstN = 0;
        int secondN = 0;
        for (int i = 0; i < nums.length; i++) {
			if((nums[i]&k)==k)
				firstN^=nums[i];
			else 
				secondN^=nums[i];
		}
        return new int[] {firstN,secondN};
    }
}
/*
Single Number III

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 */