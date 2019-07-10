package leetCode.problems._80_Remove_Duplicates_from_Sorted_Array_II;

import java.util.Arrays;

public class Solution {
	public int removeDuplicates(int[] nums) {
		int result = 0;
		if (nums.length>0)
			result++;
		else 
			return result;
		for (int i = 0; i < nums.length; i++) {
			boolean firstDup = true;
			int j;
			int temp = nums[i];
			for (j = i+1; j < nums.length; j++) {
				if (nums[j]!=temp||firstDup) {
					if(result!=j) 
						nums[result]=nums[j];
					result++;
					if(nums[j]==temp) 
						firstDup = false;
					else 
						break;
				}	
			}
			i=j-1;

		}
		return result;
	}
	public static void main(String[] args) {
		int[][]test = {
				{0,0,0,1,2,2,4,4},
				{1,2,2,2},
				{1,1,1},
				{1,1,1,2,2,3},
				{0,0,1,1,1,1,2,3,3},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			System.out.println(solution.removeDuplicates(test[i]));
			System.out.println(Arrays.toString(test[i]));
		}

	}
}
