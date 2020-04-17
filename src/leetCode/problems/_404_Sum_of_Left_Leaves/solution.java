package leetCode.problems._404_Sum_of_Left_Leaves;

import leetCode.problems.commonUtil.TreeNode;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null)
        	return 0;
        return sumOfLeftLeavesUtil(root, false);
    }
    private int sumOfLeftLeavesUtil(TreeNode root, boolean isLeft) {
    	if(root.left==null&&root.right==null) {
    		if(isLeft)
    			return root.val;
    		else 
				return 0;
    	}
    	int sum=0;
    	if(root.left!=null)
    		sum+=sumOfLeftLeavesUtil(root.left, true);
    	if(root.right!=null)
    		sum+=sumOfLeftLeavesUtil(root.right, false);
    	return sum;
    }
}
