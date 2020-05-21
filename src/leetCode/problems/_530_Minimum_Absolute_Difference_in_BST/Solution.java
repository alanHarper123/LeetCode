package leetCode.problems._530_Minimum_Absolute_Difference_in_BST;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private TreeNode preNode;
	private int minDif;
	private int dif;
    public int getMinimumDifference(TreeNode root) {
        preNode = null;
        minDif = Integer.MAX_VALUE;
        inOder(root);
        return minDif;
    }
    private void inOder(TreeNode root) {
    	if(root.left!=null)
    		inOder(root.left);
    	if(preNode!=null){
    		dif = root.val - preNode.val;
    		if(minDif>dif)
    			minDif = dif;
    	}
    	preNode = root;
    	if(root.right!=null)
    		inOder(root.right);
    }
}
