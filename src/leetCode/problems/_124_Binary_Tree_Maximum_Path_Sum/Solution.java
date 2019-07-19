package leetCode.problems._124_Binary_Tree_Maximum_Path_Sum;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private int max = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		max = Integer.MIN_VALUE;
		maxPathSumUtil(root);
		return max;
	}
	private int maxPathSumUtil(TreeNode root) {
		if(root==null)
			return 0;
		int left =maxPathSumUtil(root.left);
		int right = maxPathSumUtil(root.right);
		int a = Math.max(left, 0);
		int b = Math.max(right,0);
		int c = Math.max(left,
				right)+root.val;
		int currentMax;
		if(a==0&&b==0) 
			currentMax = 0;
		else 
			currentMax=a+b;

		currentMax+=root.val;
		if(currentMax>max)
			max = currentMax;
		return c>0?c:0;
	}
}
