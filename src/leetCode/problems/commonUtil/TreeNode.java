package leetCode.problems.commonUtil;

import java.util.ArrayList;
import java.util.List;



public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	@Override
	public String toString() {
		ArrayList<Integer> stringIntegers = new ArrayList<>() ;
		preorder(stringIntegers, this, 0);
		return stringIntegers.toString();
	}
	public static TreeNode buildTreeNode(Integer[] base,int start) {
		
		TreeNode newRoot=null;
		if(base[start]!=null) 
			newRoot = new TreeNode(base[start]);
		else 
			return null;	
		if(2*start+1<base.length)
			newRoot.left = buildTreeNode(base,2*start+1);
		if(2*start+2<base.length)
			newRoot.right = buildTreeNode(base,2*start+2);
		return newRoot;
	}
	private void preorder(List<Integer> result,TreeNode root,int start) {
		if(root == null) 
			return;
		while (result.size()<=start) {
			result.add(null);
		}
		result.set(start, root.val);
		preorder(result, root.right,2*start+2);
		preorder(result,root.left,2*start+1);
	}
	
}
