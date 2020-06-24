package leetCode.problems._724_Find_Pivot_Index;

public class Solution {
    public int pivotIndex(int[] nums) {
    	int sum = 0;
    	for(int num:nums) {
    		sum+=num;
    	}
    	int halfSum = 0;
    	for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
	   		sum-=num;
	   		if(halfSum==sum)
    			return i;
    		halfSum+=num;
		}
    	return -1;	
    }
}
