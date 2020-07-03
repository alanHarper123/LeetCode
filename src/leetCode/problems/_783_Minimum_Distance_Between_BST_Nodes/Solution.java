package leetCode.problems._783_Minimum_Distance_Between_BST_Nodes;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	int minDif;
    public int minDiffInBST(TreeNode root) {
        minDif = Integer.MAX_VALUE;
        if(root!=null)
        	inOrder(root, null);
        return minDif;
    }
    private Integer inOrder(TreeNode root,Integer pre) {
    	if(root.left!=null) {
    		pre = inOrder(root.left, pre);
    	}
    	if(pre!=null) {
    		minDif = Math.min(minDif, root.val-pre);
    	}
    	pre = root.val;
    	if(root.right!=null)
    		pre = inOrder(root.right, pre);
    	return pre;
    }
}
