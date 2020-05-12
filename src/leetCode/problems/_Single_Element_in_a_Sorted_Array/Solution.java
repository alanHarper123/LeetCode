package leetCode.problems._Single_Element_in_a_Sorted_Array;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
    	int i = 1;
        for (; i < nums.length; i+=2) {
			if(nums[i-1]!=nums[i])
				return nums[i-1];
		}
        return nums[i-1];
    }
}
