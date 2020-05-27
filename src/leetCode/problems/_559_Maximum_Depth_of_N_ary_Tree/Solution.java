package leetCode.problems._559_Maximum_Depth_of_N_ary_Tree;

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


public class Solution {
	private static int maxDepth;
	public int maxDepth(Node root) {
		
		maxDepth=0;
		maxDepthUtil(root,0);
		return maxDepth;
	}
	private void maxDepthUtil(Node root,int level) {
		if(root==null)
			return;
		else {
			level++;
			if(level>maxDepth)
				maxDepth = level;
		}
		if(root.children!=null) {
			for (Node child:root.children) {
				maxDepthUtil(child, level);
			}
		}
	}
	
}

