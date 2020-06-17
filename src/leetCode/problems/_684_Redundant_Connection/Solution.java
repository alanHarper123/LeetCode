package leetCode.problems._684_Redundant_Connection;

import java.util.ArrayList;
import java.util.LinkedList;
class Node{
	int origin;
	LinkedList<Node> neigbors = new LinkedList<>();
}
public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
    	Node[] allNodes = new Node[edges.length+1];
        for (int[] edge:edges) {
			
			Node startNode = allNodes[edge[0]];
			Node endNode = allNodes[edge[1]];
			if(startNode!=null&&endNode!=null) {
				if(startNode.origin==endNode.origin) {
					return edge;
				}else {
					changeOrigin(null, endNode, startNode.origin);
				}
			}else {
				if(startNode==null) {
					allNodes[edge[0]] = new Node();
					startNode = allNodes[edge[0]];
					startNode.origin=(endNode==null?edge[0]:endNode.origin);
				}
				if(endNode==null) {
					allNodes[edge[1]] = new Node();
					endNode = allNodes[edge[1]];
					endNode.origin = startNode.origin;
				}
			}
			
			startNode.neigbors.add(endNode);
			endNode.neigbors.add(startNode);
		}
        return new int[]{};
    }
    private void changeOrigin(Node pre,Node start,int newOrigin) {
    	start.origin=newOrigin;
    	for(Node neigbor:start.neigbors) {
    		if(neigbor!=pre)
    			changeOrigin(start, neigbor, newOrigin);
    	}
    }
}
/*
  In this problem, a tree is an undirected graph that is connected and has no cycles.

The given input is a graph that started as a tree with N nodes (with distinct values 1, 2, ..., N), with one additional edge added. The added edge has two different vertices chosen from 1 to N, and was not an edge that already existed.

The resulting graph is given as a 2D-array of edges. Each element of edges is a pair [u, v] with u < v, that represents an undirected edge connecting nodes u and v.

Return an edge that can be removed so that the resulting graph is a tree of N nodes. If there are multiple answers, return the answer that occurs last in the given 2D-array. The answer edge [u, v] should be in the same format, with u < v.

Example 1:

Input: [[1,2], [1,3], [2,3]]
Output: [2,3]
Explanation: The given undirected graph will be like this:
  1
 / \
2 - 3

Example 2:

Input: [[1,2], [2,3], [3,4], [1,4], [1,5]]
Output: [1,4]
Explanation: The given undirected graph will be like this:
5 - 1 - 2
    |   |
    4 - 3

Note:
The size of the input 2D-array will be between 3 and 1000.
Every integer represented in the 2D-array will be between 1 and N, where N is the size of the input array.
 */ 
