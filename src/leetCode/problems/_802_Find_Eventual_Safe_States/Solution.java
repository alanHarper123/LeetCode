package leetCode.problems._802_Find_Eventual_Safe_States;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        LinkedList<Integer> res = new LinkedList<>();
        int[] depth = new int[graph.length];
        for (int i = 0; i < depth.length; i++) {
			if(depth[i]==0)
				dfs(depth, i, graph, new boolean[graph.length]);
		}
        for (int i = 0; i < depth.length; i++) {
			if(depth[i]!=graph.length+1)
				res.add(i);
		}
        return res;
    }
    private int dfs(int[] depth, int i, int[][] graph,boolean[] isVisited) {

    	if(depth[i]==0) {
    		int maxDepth = 1;
    		for (int next:graph[i]) {
    			if(isVisited[next]&&depth[next]==0) {
    				maxDepth = graph.length+1;
    				break;
    			}else {
    				isVisited[next] = true;
    				maxDepth = Math.max(maxDepth, dfs(depth, next, graph, isVisited)+1);
    			}
			}
    		depth[i] = Math.min(maxDepth, graph.length+1);
    	}
    	return depth[i];
    }
    public List<Integer> eventualSafeNodes002(int[][] graph) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<Integer>[] reverseGraph = new LinkedList[graph.length];
        int[] counts = new int[graph.length];
        for (int i = 0; i < reverseGraph.length; i++) {
			reverseGraph[i] = new LinkedList<>();
			reverseGraph[i].add(i);
		}
        LinkedList<LinkedList<Integer>> ends = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
        	if(graph[i].length == 0)
        		ends.add(reverseGraph[i]);
			for (int j:graph[i]) {
				reverseGraph[j].add(i);
			}
		}
        while (!ends.isEmpty()) {
			LinkedList<Integer> end = ends.pollFirst();
			Iterator<Integer> iter = end.iterator();
			counts[iter.next()] = -1;
			while (iter.hasNext()) {
				int next = iter.next();
				counts[next]++;
				if(counts[next]==graph[next].length)
					ends.add(reverseGraph[next]);
			}
		}
        for (int i = 0; i < counts.length; i++) {
			if(counts[i]==-1)
				res.add(i);
		}
        return res;
    }
    public static void main(String[] args) {
		int[][] test = new int[][] {{},{0,2,3,4},{3},{4},{}};
		Solution solution = new Solution();
		System.out.println(solution.eventualSafeNodes(test));
	}
}
/*
802. Find Eventual Safe States
Medium

In a directed graph, we start at some node and every turn, walk along a directed edge of the graph.  If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.

Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.  More specifically, there exists a natural number K so that for any choice of where to walk, we must have stopped at a terminal node in less than K steps.

Which nodes are eventually safe?  Return them as an array in sorted order.

The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.  The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.

Example:
Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
Output: [2,4,5,6]
Here is a diagram of the above graph.

Illustration of graph

Note:

    graph will have length at most 10000.
    The number of edges in the graph will not exceed 32000.
    Each graph[i] will be a sorted list of different integers, chosen within the range [0, graph.length - 1].
 */
