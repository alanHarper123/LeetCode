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
		for (int i = 0,pre=result.length-1; i < result.length;) {
			if(nums[i]>nums[pre]) {
				result[pre] = nums[i];
				while (unsolvedIndexs.size()>0&&nums[i]>nums[unsolvedIndexs.peekLast()]) {
					result[unsolvedIndexs.pollLast()] = nums[i];
				}
			}else 
				unsolvedIndexs.add(pre);
			pre++;
			i++;
			if(pre==result.length)
				pre = 0;
		}
		for (int i = 0; i < result.length; i++) {
			while (unsolvedIndexs.size()>0&&nums[i]>nums[unsolvedIndexs.peekLast()]) {
				result[unsolvedIndexs.pollLast()] = nums[i];
			}
		}
		while (unsolvedIndexs.size()>0) {
			result[unsolvedIndexs.pollLast()] = -1;
		}
		return result;
	}
}
