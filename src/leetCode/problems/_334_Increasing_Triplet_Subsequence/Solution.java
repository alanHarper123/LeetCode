package leetCode.problems._334_Increasing_Triplet_Subsequence;

class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer minSecond = null;
        Integer minFirst = null;
        for (int i = 0,j=1; j < nums.length; j++,i++) {
			if(nums[i]<nums[j]) {
				if(minSecond==null) {
					minSecond = nums[j];
					minFirst = nums[i];
				}
				else {
					if(nums[j]>minSecond)
						return true;
					else {
						if(minFirst<nums[i])
							return true;
						minFirst = nums[i];
						minSecond = nums[j];
					}
				}
			}
		}
        return false;
    }
}
