package leetCode.problems._590_N_ary_Tree_Postorder_Traversal;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


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
    public List<Integer> postorder(Node root) {
    	LinkedList<Integer> list = new LinkedList<>();
    	if(root==null)
    		return list;
    	LinkedList<Node> unTraversedNodes = new LinkedList<>();
    	unTraversedNodes.add(root);
    	while (!unTraversedNodes.isEmpty()) {
			Node node = unTraversedNodes.pollLast();
			list.addFirst(node.val);
			for(Node child:node.children)
				unTraversedNodes.add(child);
		}
    	return list;
    }
}
