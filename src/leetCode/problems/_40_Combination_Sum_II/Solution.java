package leetCode.problems._40_Combination_Sum_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
	HashSet<List<Integer>> results = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	if(candidates.length!=0&&candidates[0]<=target) {
    		backTracking(candidates, new ArrayList<>(), candidates.length-1, target);
    	}
    	
        return new ArrayList<>(results);
    }
    
    public void backTracking(int[] candidates,List<Integer> result,int start, int remainder) {
    	if(remainder==0) {results.add(new ArrayList<>(result)); return;}
    	for (int i = start; i > -1; i--) {
    		if(candidates[i]>remainder) {
    			continue;
    		}
			result.add(candidates[i]);
			backTracking(candidates,result,i-1,remainder-candidates[i]);
			result.remove(result.size()-1);
		}
    }
}
