package leetCode.problems._219_Contains_Duplicate_II;

import java.util.HashMap;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> base = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			Integer preL = base.get(nums[i]);
			if(preL==null)
				base.put(nums[i], i);
			else {
				if(i-preL<=k)
					return true;
				else {
					base.put(nums[i], i);
				}
			}
		}
        return false;
    }
}
