package leetCode.problems._747_Largest_Number_At_Least_Twice_of_Others;

public class Solution {
    public int dominantIndex(int[] nums) {
    	if(nums.length==1)
    		return 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        int secondMax = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
        	int num = nums[i];
        	if(num>max) {
        		secondMax = max;
        		max = num;
        		maxIndex = i;
        	}else if(num>secondMax) {
        		secondMax = num;
        	}
        }
        if(max-secondMax>=secondMax) {
        	return maxIndex;
        }
        return -1;
    }
}
