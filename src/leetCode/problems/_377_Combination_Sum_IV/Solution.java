package leetCode.problems._377_Combination_Sum_IV;


public class Solution {
	private Integer[] targets;
	private int[] nums;
    public int combinationSum4(int[] nums, int target) {
    	this.nums = nums;
        targets = new Integer[target+1];
        targets[0]=1;
        return combinationSum4Util(target);
    }
    private int combinationSum4Util(int target) {
    	if(targets[target]!=null)
    		return targets[target];
    	int sum=0;
    	for (int i = 0; i < nums.length; i++) {
			if(target-nums[i]>=0)
				sum+=combinationSum4Util(target-nums[i]);
		}
    	targets[target] = sum;
    	return sum;
    }
}
