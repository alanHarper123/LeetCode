package leetCode.problems._310_Minimum_Height_Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	private int[] connetionCs;

	private LinkedList<Integer>[] neibors;
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		connetionCs = new int[n];
		int left = n;
		neibors = (LinkedList<Integer>[]) new LinkedList[n];

		for (int i = 0; i < n; i++) {
			neibors[i] = new LinkedList<>();
		}
		for(int[] edge:edges) {
			neibors[edge[0]].add(edge[1]);
			neibors[edge[1]].add(edge[0]);
			connetionCs[edge[0]]++;
			connetionCs[edge[1]]++;
		}
		Queue<Integer> looseEnds = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if(connetionCs[i]<=1) {
				looseEnds.add(i);
			}

		}
		LinkedList<Integer> results = new LinkedList<>();
		while (!looseEnds.isEmpty()) {
			if(left==1||left==2) {
				results.addAll(looseEnds);
				return results;
			}
			int count = looseEnds.size();
			left-=count;
			for (int i = 0; i < count; i++) {
				int looseEnd = looseEnds.poll();
				for (int next : neibors[looseEnd]) {
					
						if(connetionCs[next]==2) {
							connetionCs[next]--;
							looseEnds.add(next);
						}else {
							connetionCs[next]--;
						}
					
				}

			}
            
			
		}
		return results;
	}
}
