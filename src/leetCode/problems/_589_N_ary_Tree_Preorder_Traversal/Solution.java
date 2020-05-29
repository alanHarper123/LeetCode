package leetCode.problems._589_N_ary_Tree_Preorder_Traversal;

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
    public List<Integer> preorder(Node root) {
    	List<Integer> list = new LinkedList<>();
    	if(root==null)
    		return list;
    	LinkedList<Node> unTraversedNodes = new LinkedList<>();
    	unTraversedNodes.add(root);
    	while (!unTraversedNodes.isEmpty()) {
			Node node = unTraversedNodes.pollFirst();
			list.add(node.val);
			if(node.children!=null) {
				ListIterator<Node> li = 
						node.children.listIterator(node.children.size());
				while (li.hasPrevious()) {
					unTraversedNodes.addFirst(li.previous());
				}
			}
		}
    	return list;
    }
}
