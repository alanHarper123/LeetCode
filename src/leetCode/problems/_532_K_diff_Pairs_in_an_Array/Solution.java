package leetCode.problems._532_K_diff_Pairs_in_an_Array;

import java.util.HashSet;
import java.util.Map.Entry;

public class Solution {
    public int findPairs(int[] nums, int k) {
    	if(k<0)
    		return 0;
        HashSet<Integer> uniques = new HashSet<>();
        
        int count = 0;
        if(k==0) {
        	HashSet<Integer> duplicates = new HashSet<>();
        	for (int i = 0; i < nums.length; i++) {
    			if(!uniques.add(nums[i])) {
    				duplicates.add(nums[i]);
    			};
    		}
        	return duplicates.size();
        }else {
        	for (int i = 0; i < nums.length; i++) {
    			uniques.add(nums[i]);
    		}
        }
        for (int unique:uniques) {
			if(uniques.contains(unique+k))
				count++;
		}
        return count;
    }
}
