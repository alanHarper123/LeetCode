package leetCode.problems._403_Frog_Jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public boolean canCross(int[] stones) {
    	//DFS
    	if(stones.length<=1)
    		return true;
    	HashMap<Integer, Integer> stoneValueToIndex = new HashMap<>(stones.length);
    	HashSet<Integer>[] stonesVisited = new HashSet[stones.length];
    	for (int i = 0; i < stones.length; i++) {
			stoneValueToIndex.put(stones[i], i);
		}
    	return dfs(0, 0, stones, stoneValueToIndex, stonesVisited);

    }

    private boolean dfs(int jumpStep,int frontier,int[] stones, 
    		HashMap<Integer, Integer> stoneValueToIndex,
    		HashSet<Integer>[] stonesVisited) {
    	if(frontier==stones.length-1)
    		return true;
    	if(jumpStep>=0) {
    		int nextStoneV = jumpStep+stones[frontier];
    		if(stoneValueToIndex.containsKey(nextStoneV)) {
    			int nextIndex = stoneValueToIndex.get(nextStoneV);
    			if(stonesVisited[nextIndex]==null) {
    				stonesVisited[nextIndex] = new HashSet<>();
    			}else if(stonesVisited[nextIndex].contains(jumpStep)) {
    				return false;
    			}
    			stonesVisited[nextIndex].add(jumpStep);
    			if(dfs(jumpStep, nextIndex, stones, stoneValueToIndex, stonesVisited)
    					||dfs(jumpStep+1, nextIndex, stones, stoneValueToIndex, stonesVisited)
    					||dfs(jumpStep-1, nextIndex, stones, stoneValueToIndex, stonesVisited)
    					)
    				return true;
    		}
    	}
    	return false;
    	
    }
    private boolean jump(int jump,int frontier,int[] stones, 
    		HashMap<Integer, Integer> stoneValueToIndex,LinkedList<Integer> frontiers,
    		HashSet<Integer[]> stonesVisited) {
    	if(jump>0) {
    		jump = stones[frontier]+jump;
			if(jump==stones[stones.length-1])
				return true;
			
			if(
				!stonesVisited.contains(new Integer[] {jump,jump-stones[frontier]})
				&&stoneValueToIndex.containsKey(jump)) {
				int nextIndex = stoneValueToIndex.get(jump);
				stonesVisited.add(new Integer[] {jump,jump-stones[frontier]});
				frontiers.add(nextIndex);
				frontiers.add(jump-stones[frontier]);
			}
		}
    	return false;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[] stonesTest = new int[] {0,1,3,6,10,13,15,18};
		System.out.println(solution.canCross(stonesTest));
	}
}
