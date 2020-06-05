package leetCode.problems._643_Maximum_Average_Subarray_I;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
    	int sum=0;
    	int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
			if(i>=k) {
				if(maxSum<sum)
					maxSum = sum;
				sum-=nums[i-k];
			}
			sum+=nums[i];
		}
        if(maxSum<sum)
			maxSum = sum;
        return ((double)maxSum)/k;
    }
}
