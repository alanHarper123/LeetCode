package leetCode.problems._485_Max_Consecutive_Ones;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
    	int maxCount = 0;
        for (int i = 0; i < nums.length; ) {
        	if(nums[i]==1) {
        		int counti=1;
        		i++;
    			while (i<nums.length&&nums[i]==1) {
    				i++;
    			}
    			if(counti>maxCount)
    				maxCount = counti;
        	}else {
        		i++;
        		while(i<nums.length&&nums[i]==0) {
        			i++;
        		}
        	}
		}
        return maxCount;
    }
}
