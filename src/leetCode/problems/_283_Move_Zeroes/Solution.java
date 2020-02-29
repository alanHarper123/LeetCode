package leetCode.problems._283_Move_Zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]==0)
				zeroCount++;
			else if(zeroCount!=0) {
				nums[i-zeroCount] = nums[i];
			}
		}
        for (int i = 0; i < zeroCount; i++) {
			nums[nums.length-1-i]=0;
		}
    }
}
