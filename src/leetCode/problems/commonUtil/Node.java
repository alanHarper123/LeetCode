package leetCode.problems.commonUtil;

import java.util.ArrayList;
import java.util.List;

//Definition for a Node.
public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {}

	public Node(int _val,Node _left,Node _right,Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
	public static Node buildTreeNode(Integer[] base,int start) {

		Node newRoot=null;
		if(base[start]!=null) 
			newRoot = new Node(base[start],null,null,null);
		else 
			return null;	
		if(2*start+1<base.length)
			newRoot.left = buildTreeNode(base,2*start+1);
		if(2*start+2<base.length)
			newRoot.right = buildTreeNode(base,2*start+2);
		return newRoot;
	}
	@Override
	public String toString() {
		ArrayList<Integer> stringIntegers = new ArrayList<>() ;
		preorder(stringIntegers, this, 0);
		return stringIntegers.toString();
	}
	private void preorder(List<Integer> result,Node root,int start) {
		if(root == null) 
			return;
		while (result.size()<=start) {
			result.add(null);
		}
		result.set(start, root.val);
		preorder(result, root.right,2*start+2);
		preorder(result,root.left,2*start+1);
	}
};
