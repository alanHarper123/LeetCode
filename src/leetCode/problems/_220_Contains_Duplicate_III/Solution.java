package leetCode.problems._220_Contains_Duplicate_III;

public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	long judge;
        for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j <= i+k&&j<nums.length; j++) {
				judge = (long)nums[j]-(long)nums[i];
				if(judge<0)
					judge=-judge;
				if(judge<=t)
					return true;
			}
		}
        return false;
    }
    public static void main(String[] args) {
		int[][] test1 = {
				{-1,2147483647},
		};
		int[] test2 = {1};
		int[] test3 = {2147483647};
		Solution solution = new Solution();
		for (int i = 0; i < test3.length; i++) {
			System.out.println(solution.
					containsNearbyAlmostDuplicate(test1[i], test2[i], test3[i]));
		}
	}
}
