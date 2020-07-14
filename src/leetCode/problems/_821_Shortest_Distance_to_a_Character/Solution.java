package leetCode.problems._821_Shortest_Distance_to_a_Character;

import java.util.LinkedList;

public class Solution {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];
        boolean[] isVisited = new boolean[S.length()];
        LinkedList<Integer> bfs_frontiers = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
			if(S.charAt(i)==C) {
				bfs_frontiers.add(i);
				isVisited[i] = true;
			}
		}
        while (!bfs_frontiers.isEmpty()) {
			int width = bfs_frontiers.size();
			while (width>0) {
				width--;
				int frontier = bfs_frontiers.pollFirst();
				for (int i = -1; i < 2; i+=2) {
					int newFrontier = frontier+i;
					if(newFrontier<0||
							newFrontier==S.length()||isVisited[newFrontier])
						continue;
					isVisited[newFrontier] = true;
					res[newFrontier] = res[frontier]+1;
					bfs_frontiers.add(newFrontier);
				}
			}
		}
        return res;
    }
}
