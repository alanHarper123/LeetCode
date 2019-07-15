package leetCode.problems._101_Symmetric_Tree;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        	return true;
        else 
        	return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right) {
    	if(left==null) {
    		if(right!=null)
    			return false;
    	}else if(right==null)
    		return false;
    	else {
    		if(left.val != right.val)
    			return false;
    		if(!isSymmetric(left.left,right.right))
    			return false;
    		if(!isSymmetric(left.right,right.left))
    			return false;
    	}
    	return true;
    }
}
