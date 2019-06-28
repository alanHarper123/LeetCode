package leetCode.problems._39_Combination_Sum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	backTracking(candidates, new ArrayList<>(), 0, target);
        return results;
    }
    
    public void backTracking(int[] candidates,List<Integer> result,int start, int remainder) {
    	if(remainder<0) {return;}
    	if(remainder==0) {results.add(new ArrayList<>(result)); return;}
    	for (int i = start; i < candidates.length; i++) {
			result.add(candidates[i]);
			backTracking(candidates,result,i,remainder-candidates[i]);
			result.remove(result.size()-1);
		}
    }
}
