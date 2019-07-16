package leetCode.problems._111_Minimum_Depth_of_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	int minimumDepth;
	public int minDepth(TreeNode root) {
		if(root==null)
			return 0;
		minimumDepth = Integer.MAX_VALUE;
		minDepth(root, 1);
		return minimumDepth;
	}
	private void minDepth(TreeNode root, int level) {
		if(root.left==null&&root.right==null) {
			if(level<minimumDepth)
				minimumDepth=level;
			return;
		}
		if(level>=minimumDepth)
			return;
		if(root.left!=null)
			minDepth(root.left,level+1);
		if(root.right!=null)
			minDepth(root.right, level+1);
	}
}
