package leetCode.problems.three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	
    	List<List<Integer>> result = new ArrayList<>();
    	
    	Arrays.sort(nums);
        for (int i = 0; i<nums.length-2; i++) {
            if(nums[i]+nums[i+1]>0)break;
        	while(i!=0&&i<nums.length-2&&nums[i]==nums[i-1]) {
        		i++;
        	}
        	int lo = i+1, hi = nums.length-1, target = 0 - nums[i];
        	while (lo<hi) {
            	if(nums[lo]+nums[hi]==target) {
            		result.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
            		while(lo<hi&&nums[lo]==nums[lo+1]) lo++;
            		while(hi-1>i&&nums[hi]==nums[hi-1]) hi--;
            		lo++; hi--;
            	}else if (nums[lo]+nums[hi]<target) lo++;
            	else hi--;
				
			}
        } 

       
        return result;
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
    	int[] test = {-2,0,1,1,2};
    	System.out.println(solution.threeSum(test));
	}
}
