package leetCode.problems._226_Invert_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
    	recursiveInvert(root);
        return root;
    }
    private void recursiveInvert(TreeNode root) {
    	if(root == null)
    		return;
    	else {
    		TreeNode temp = root.right;
    		root.right = root.left;
    		root.left = temp;
    		recursiveInvert(root.left);
    		recursiveInvert(root.right);
    	}
    }
}
