package leetCode.problems._100_Same_Tree;


// Definition for a binary tree node.
import leetCode.problems.commonUtil.TreeNode;

class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null) {
			if(q!=null)
				return false;
		}else if(q==null)
			return false;
		else {
			if(p.val!=q.val) 
				return false;
			if(!isSameTree(p.left,q.left))
				return false;
			if(!isSameTree(p.right,q.right))
				return false;
		}
		return true;
	}
}
