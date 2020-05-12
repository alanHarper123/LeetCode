package leetCode.problems._494_Target_Sum;

import java.util.HashMap;

public class Solution {
	private HashMap<Integer, Integer>[] targetCounts;
    public int findTargetSumWays(int[] nums, int S) {
    	targetCounts = new HashMap[nums.length];
    	for (int i = 0; i < nums.length; i++) {
			targetCounts[i] = new HashMap<>();
		}
        return findTargetSumWaysutil(nums, S, nums.length-1);
    }
    private int findTargetSumWaysutil(int[] nums,int S, int index) {
    	Integer count = targetCounts[index].get(S);
    	if(count==null) {
    		if(index==0) {
        		count = 0;
        		if(nums[0]==S)
        			count++;
        		if(nums[0]+S==0)
        			count++;
    			
        	}else {
        		count = findTargetSumWaysutil(nums, S-nums[index], index-1)
        				+findTargetSumWaysutil(nums, S+nums[index], index-1);
        	}
    		targetCounts[index].put(S, count);
    	}
    	return count;
    }
}
