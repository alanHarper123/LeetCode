package leetCode.problems._310_Minimum_Height_Trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
	private int[] connetionCs;
	private Integer[] levels;
	private LinkedList<Integer>[] neibors;
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		connetionCs = new int[n];
		neibors = (LinkedList<Integer>[]) new LinkedList[n];
		levels = new Integer[n];
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
			if(connetionCs[i]==1) {
				looseEnds.add(i);
			}

		}
		int level = 0;
		LinkedList<Integer> results = new LinkedList<>();
		while (!looseEnds.isEmpty()) {
			level++;
			int count = looseEnds.size();
			for (int i = 0; i < count; i++) {
				int looseEnd = looseEnds.poll();
				levels[looseEnd]=level;
				for (int next : neibors[looseEnd]) {
					if(levels[next]==null) {
						if(connetionCs[next]==1)
							results.add(next);
						else if(connetionCs[next]==2) {
							connetionCs[next]--;
							looseEnds.add(next);
						}else {
							connetionCs[next]--;
						}
					}else {
						if(levels[next].equals(levels[looseEnd]))
							results.add(looseEnd);
					}
				}
				
			}
			
		}
		if(n==0)
			results.add(0);
		return results;
	}
}
