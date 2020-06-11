package leetCode.problems._653_Two_Sum_IV_Input_is_a_BST;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
        	return false;
        return findTargetUtil(root, root, k);
    }
    private boolean findTargetUtil(TreeNode root,TreeNode subRoot, int k) {
    	int num = k-subRoot.val;
    	if(num!=subRoot.val&&findNumInBinaryTree(root, num))
    		return true;
    	if(subRoot.left!=null)
    		if(findTargetUtil(root, subRoot.left, k))
    			return true;
    	if(subRoot.right!=null)
    		if(findTargetUtil(root, subRoot.right, k))
    			return true;
    	return false;
    }
    private boolean findNumInBinaryTree(TreeNode root,int num) {
    	if(root==null)
    		return false;
    	if(root.val==num) {
    		return true;
    	}else if(root.val<num)
    		return findNumInBinaryTree(root.right, num);
    	else 
    		return findNumInBinaryTree(root.left, num);
		
    }
}
