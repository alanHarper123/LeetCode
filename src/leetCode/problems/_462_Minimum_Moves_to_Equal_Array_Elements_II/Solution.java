package leetCode.problems._462_Minimum_Moves_to_Equal_Array_Elements_II;

import java.util.Random;

public class Solution {
//	private Random rand = new Random(System.currentTimeMillis());
	public int minMoves2(int[] nums) {
		int sum = 0;
		int midian = findKth(nums, 0, nums.length, nums.length/2);
		int minDif = 0;
		for (int i = 0; i < nums.length; i++) {
			minDif+=Math.abs(nums[i]-midian);
		}
		return minDif;
	}
	private int findKth(int[] nums,int start,int end,int k) {
		int pivot = nums[start+(end-start)/2];
		int dupC = 0;
		int pivoti = nums.length-1;
		for (int i = start; i <=pivoti; ) {
			if(nums[i]>=pivot) {
				if(nums[i]==pivot) 
					dupC++;
				int temp = nums[pivoti];
				nums[pivoti--] = nums[i];
				nums[i]=temp;
			}else 
				i++;
		}

		if(k<=pivoti) {
			return findKth(nums, start, pivoti, k);
		}else if(k>pivoti+dupC) {
			return findKth(nums, pivoti+1, end, k);
		}else 
			return pivot;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = new int[] {1,2,3};
		System.out.println(solution.minMoves2(test));
	}
}
