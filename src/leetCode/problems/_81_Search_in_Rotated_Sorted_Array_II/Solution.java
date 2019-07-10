package leetCode.problems._81_Search_in_Rotated_Sorted_Array_II;


public class Solution {
	public boolean search(int[] nums, int target) {
		if(nums.length==0) {
			return false;
		}
		int pivot = -1;
		int aMin = 0;
		int aMax = nums.length-1;
		int i=0;
		if(nums[aMin]==nums[aMax]) {
			for (i = aMin+1; i < nums.length; i++) {
				if(nums[aMin]<nums[i]) {
					aMin = i;
					break;
				}else if (nums[aMin]>nums[i]) {
					pivot = i;
					break;
				}
			}
		}else if (nums[aMin]<nums[aMax]) {
			pivot = aMin;
		}

		if (i==nums.length){
			pivot=0;
		}else if(pivot==-1){
			pivot = (aMax+aMin)/2;
			while (nums[(pivot==0?nums.length-1:pivot-1)]
					<=nums[pivot]) {
				if(aMin>=aMax) {
					pivot = 0;
					break;
				}
				if(nums[pivot]>nums[aMax]) {
					if(nums[aMin]>nums[pivot+1]) {
						pivot++;
						break;
					}
					aMin = pivot+1;
				}
				else if(nums[pivot]<nums[aMax])
					aMax=pivot;
				else
					aMax = pivot;
				pivot = (aMax+aMin)/2;
			}
		}
		aMin = pivot;
		aMax = pivot+nums.length;
		int j = (aMin+aMax)/2%nums.length;
		while (aMin<aMax) {
			if(nums[j]>target) 
				aMax = (j>=pivot?j:j+nums.length);
			else if (nums[j]<target) 
				aMin = (j>=pivot?j:j+nums.length)+1;
			else 
				return true;
			j=(aMin+aMax)/2%nums.length;
		}
		return false;
	}
	public static void main(String[] args) {
		int[][]test = {
				{1,2,2,2,0,1,1},
				{3,1},
				{1,1,1,1,3},
				{1,3},
				{1,1},
				{3,1,1,1},
				{1,3,1,1},
				{1},
				{2,5,6,0,0,1,2},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			System.out.println(solution.search(test[i],0));
			System.out.println(solution.search(test[i],3));
		}
	}
}
