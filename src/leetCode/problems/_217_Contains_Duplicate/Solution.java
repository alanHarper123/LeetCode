package leetCode.problems._217_Contains_Duplicate;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> base = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
			if(!base.add(nums[i]))
				return true;
		}
        return false;
    }
}
