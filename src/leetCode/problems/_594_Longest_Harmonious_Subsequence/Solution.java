package leetCode.problems._594_Longest_Harmonious_Subsequence;

import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> numToCounts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			int count = numToCounts.getOrDefault(nums[i], 0);
			numToCounts.put(nums[i], count+1);
		}
        int maxL = 0;
        Integer l;
        for(Entry<Integer, Integer> numToCount:numToCounts.entrySet()) {
        	l=numToCounts.get(numToCount.getKey()+1);
        	if(l==null)
        		continue;
        	 l+= numToCount.getValue();
        	if(l>maxL)
        		maxL = l;
        }
        return maxL;
    }
}
