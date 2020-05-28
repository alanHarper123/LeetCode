package leetCode.problems._572_Subtree_of_Another_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		if(t==null)
			return true;
		if(s==null)
			return false;
		if(s.val==t.val) {
			if(ifTreeEqual(s, t))
				return true;
		}
		if(isSubtree(s.left, t)||isSubtree(s.right, t))
			return true;

		return false;
	}
	private boolean ifTreeEqual(TreeNode t1, TreeNode t2) {
		if(t1==null&&t2==null)
			return true;
		if(t1==null||t2==null)
			return false;
		if(t1.val==t2.val) {
			return ifTreeEqual(t1.left, t2.left)&&
					ifTreeEqual(t1.right, t2.right);
		}
		return false;
	}
}
