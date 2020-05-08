package leetCode.problems._486_Predict_the_Winner;

public class Solution {
    public boolean PredictTheWinner(int[] nums) {
    	if(nums==null||nums.length<=2)
    		return true;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
        int avg = sum/2+sum%2;
        Integer[][] picks = new Integer[nums.length][nums.length];
        return pickUtil(picks, nums, 0, nums.length-1, sum)>=avg;
        
    }
    private int pickUtil(Integer[][] picks, int[] nums,int start,int end,int sum) {
    	if(picks[start][end]!=null) {
    		return picks[start][end];
    	}else {
    		if(start==end)
    			return nums[start];
    		else {
    			int pick1 = nums[start];
    			int sum1 = sum-pick1;
    			pick1 = pick1+sum1-pickUtil(picks, nums, start+1, end, sum1);
    			int pick2 = nums[end];
    			sum1 = sum-nums[end];
    			pick2 = pick2+sum1-pickUtil(picks, nums, start, end-1, sum1);
    			picks[start][end] = Math.max(pick1, pick2);
    			return picks[start][end];
    		}
    	}
    }
}
