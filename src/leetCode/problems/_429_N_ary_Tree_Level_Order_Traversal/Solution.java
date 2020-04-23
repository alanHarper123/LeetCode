package leetCode.problems._429_N_ary_Tree_Level_Order_Traversal;

import java.util.LinkedList;
import java.util.List;

//Definition for a Node.
class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
};


class Solution {
	public List<List<Integer>> levelOrder(Node root) {
		
		List<List<Integer>> targetList = new LinkedList<>();
		if(root==null)
			return targetList;
		LinkedList<Node> frontiers = new LinkedList<>();
		frontiers.add(root);
		while (!frontiers.isEmpty()) {
			int count = frontiers.size();
			List<Integer> levelList = new LinkedList<>();
			while (count!=0) {
				Node frontier = frontiers.pollFirst();
				levelList.add(frontier.val);
				for (Node child : frontier.children) {
					frontiers.add(child);
				}
				count--;
			}
			targetList.add(levelList);
		}
		return targetList;
	}
}
