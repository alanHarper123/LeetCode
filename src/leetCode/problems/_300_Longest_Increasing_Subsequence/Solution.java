package leetCode.problems._300_Longest_Increasing_Subsequence;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0)
        	return 0;
        int[] base = new int[nums.length];
        Arrays.fill(base, 1);
        int max = 1;
        for (int i = base.length-2; i > -1; i--) {
			int k = nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if(k<nums[j]&&base[i]<base[j]+1)
					base[i]=base[j]+1;
			}
			if(base[i]>max)
				max = base[i];
		}
        return max;
    }
}
