package leetCode.problems._453_Minimum_Moves_to_Equal_Array_Elements;

import java.util.Arrays;

public class Solution {
    public int minMoves(int[] nums) {
    	int moveC = 0;
    	if(nums==null||nums.length<2)
        	return moveC;
        Arrays.sort(nums);
        int ceiling = nums[nums.length-1];
        int stepCount = 1;
        for (int i = nums.length-2; i >=0; i--) {
			int dif = ceiling-nums[i];
			ceiling = nums[i];
			moveC+=dif*(stepCount++);
		}
        return moveC;
    }
}
