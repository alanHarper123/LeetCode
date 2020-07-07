package leetCode.problems._797_All_Paths_From_Source_to_Target;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> cur = new LinkedList<>();
        cur.add(0);
        dfs(res, cur, graph, 0);
        return res;
    }
    private void dfs(LinkedList<List<Integer>> res, LinkedList<Integer> cur,
    		int[][] graph, int i) {
    	if(i==graph.length-1) {
    		res.add(new LinkedList<>(cur));
    		return;
    	}
    	for(int next:graph[i]) {
    		cur.add(next);
    		dfs(res, cur, graph, next);
    		cur.pollLast();
    	}
    }
}
/*
797. All Paths From Source to Target
Medium

Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

Example:
Input: [[1,2], [3], [3], []] 
Output: [[0,1,3],[0,2,3]] 
Explanation: The graph looks like this:
0--->1
|    |
v    v
2--->3
There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.

Note:

    The number of nodes in the graph will be in the range [2, 15].
    You can print different paths in any order, but you should keep the order of nodes inside one path.
 */
