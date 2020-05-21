package leetCode.problems._538_Convert_BST_to_Greater_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int largerSum;
    public TreeNode convertBST(TreeNode root) {
        largerSum = 0;
        if(root!=null)
        	postOrder(root);
        return root;
    }
    private void postOrder(TreeNode root) {
    	if(root.right!=null)
    		postOrder(root.right);
    	largerSum+=root.val;
    	root.val=largerSum;
    	if(root.left!=null)
    		postOrder(root.left);
    }
}
