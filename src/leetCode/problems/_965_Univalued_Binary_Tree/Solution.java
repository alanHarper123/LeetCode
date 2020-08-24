package leetCode.problems._965_Univalued_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private boolean isUnival;
	private int val;
    public boolean isUnivalTree(TreeNode root) {
        isUnival = true;
        val = root.val;
        isUnivalTreeUtil(root);
        return isUnival;
    }
    private void isUnivalTreeUtil(TreeNode root) {
    	if(root.val!=val) {
    		isUnival = false;
    		return;
    	}
    	if(root.left!=null)
    		isUnivalTreeUtil(root.left);
    	if(isUnival&&root.right!=null)
    		isUnivalTreeUtil(root.right);
    }
}
