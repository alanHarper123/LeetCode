package leetCode.problems.Search_Insert_Position;

import java.util.EnumSet;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int result = -1;
        int low = 0, high = nums.length-1;
        int halfLength = 0;
        while (low<=high) {
			halfLength = (low+high)/2;
			if(target>nums[halfLength]) {
				if(halfLength==nums.length-1) return nums.length;
				else if (target<=nums[halfLength+1]) return halfLength+1;
				else low = halfLength+1;
			}else {
				if(halfLength==0) return halfLength;
				else high = halfLength;
			}			
		}
        return result;
    }
    public static void main(String[] args) {
		int[] test = {1,3,5,6};
		System.out.println(new Solution().searchInsert(test, 7));
	}
}
