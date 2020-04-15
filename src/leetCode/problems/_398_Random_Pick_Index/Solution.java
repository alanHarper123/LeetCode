package leetCode.problems._398_Random_Pick_Index;

import java.util.HashMap;
import java.util.Random;

public class Solution {
	private HashMap<Integer, HashMap<Integer,Integer>> indexs;
	Random rand = new Random(System.currentTimeMillis());
    public Solution(int[] nums) {
        indexs = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
        	HashMap<Integer,Integer> indexmap = indexs.get(nums[i]);
			if(indexmap==null) {
				indexmap = new HashMap<>();
				indexs.put(nums[i], indexmap);
			}
			indexmap.put(indexmap.size(),i);	
		}
    }
    
    public int pick(int target) {
    	HashMap<Integer,Integer> indexmap = indexs.get(target);
    	if(indexmap!=null)
    		return indexmap.get(rand.nextInt(indexmap.size()));
    	return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
