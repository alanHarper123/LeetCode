package leetCode.problems._1129_Shortest_Path_with_Alternating_Colors;

import java.util.LinkedList;

public class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[] res = new int[n];
        for (int i = 1; i < res.length; i++) {
			res[i] = -1;
		}
        boolean[][] colorVisited = new boolean[n][2];
        LinkedList<Integer>[][] allNodes = new LinkedList[n][2];
        for (int i = 0; i < allNodes.length; i++) {
			allNodes[i][0] = new LinkedList<>();
			allNodes[i][1] = new LinkedList<>();
		}
        for(int[] red_edge:red_edges) {
        	allNodes[red_edge[0]][0].add(red_edge[1]);
        }
        for(int[] blue_edge:blue_edges) {
        	allNodes[blue_edge[0]][1].add(blue_edge[1]);
        }
        LinkedList<Integer> frontiers = new LinkedList<>();
        frontiers.add(0);
        frontiers.add(0);
        frontiers.add(0);
        frontiers.add(1);
        colorVisited[0][0] = true;
        colorVisited[0][1] = true;
        int step = 0;
        while (!frontiers.isEmpty()) {
        	step++;
			int size = frontiers.size()/2;
			while (size>0) {
				size--;
				int ni = frontiers.pollFirst();
				int color = frontiers.pollFirst();
				for(int node:allNodes[ni][color]) {
					if(!colorVisited[node][1-color]) {
						colorVisited[node][1-color] = true;
						if(res[node]==-1)
							res[node] = step;
						frontiers.add(node);
						frontiers.add(1-color);
					}
				}
			}
		}
        return res;
    }
}
/*
1129. Shortest Path with Alternating Colors
Medium

Consider a directed graph, with nodes labelled 0, 1, ..., n-1.  In this graph, each edge is either red or blue, and there could be self-edges or parallel edges.

Each [i, j] in red_edges denotes a red directed edge from node i to node j.  Similarly, each [i, j] in blue_edges denotes a blue directed edge from node i to node j.

Return an array answer of length n, where each answer[X] is the length of the shortest path from node 0 to node X such that the edge colors alternate along the path (or -1 if such a path doesn't exist).

 

Example 1:

Input: n = 3, red_edges = [[0,1],[1,2]], blue_edges = []
Output: [0,1,-1]

Example 2:

Input: n = 3, red_edges = [[0,1]], blue_edges = [[2,1]]
Output: [0,1,-1]

Example 3:

Input: n = 3, red_edges = [[1,0]], blue_edges = [[2,1]]
Output: [0,-1,-1]

Example 4:

Input: n = 3, red_edges = [[0,1]], blue_edges = [[1,2]]
Output: [0,1,2]

Example 5:

Input: n = 3, red_edges = [[0,1],[0,2]], blue_edges = [[1,0]]
Output: [0,1,1]

 

Constraints:

    1 <= n <= 100
    red_edges.length <= 400
    blue_edges.length <= 400
    red_edges[i].length == blue_edges[i].length == 2
    0 <= red_edges[i][j], blue_edges[i][j] < n
*/