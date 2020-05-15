package leetCode.problems._503_Next_Greater_Element_II;

import java.util.LinkedList;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
    	if(nums==null)
    		return null;
        int[] result = new int[nums.length];
        if(nums.length==0)
    		return result;
        if(nums.length==1) {
        	result[0]=-1;
        	return result;
        }
        LinkedList<Integer> unsolvedIndexs = new LinkedList<>();
        for (int i = 1; i < result.length; i++) {
			if(nums[i]>nums[i-1]) {
				result[i-1] = nums[i];
			}
			else 
				unsolvedIndexs.add(i-1);
			
		}
        
    }
}
