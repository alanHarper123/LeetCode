package leetCode.problems.Remove_Element_27;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
        	if(nums[i]!=val) {
        		if(result!=i) {
        			nums[result]=nums[i];
        		}
        		result++;
        	}
		}
        return result;
    }
}
