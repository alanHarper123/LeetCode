package leetCode.problems._1218_Longest_Arithmetic_Subsequence_of_Given_Difference;

import java.util.HashMap;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
    	HashMap<Integer, Integer> base = new HashMap<>();
    	int maxL = 1;
        for(int e:arr) {
        	Integer len = base.remove(e);
        	Integer nexLen = base.get(e+difference);
        	if(len==null) {
        		if(nexLen==null) {
        			base.put(e+difference, 1);
        		}
        	}else {
        		if(maxL<len+1)
        			maxL = len+1;
        		if(nexLen==null||nexLen<len+1)
        			base.put(e+difference, len+1);
        	}
        }
        return maxL;
    }
}
