package leetCode.problems._701_Insert_into_a_Binary_Search_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) {
        	return new TreeNode(val);
        }
        insertIntoBST_util(root, val);
        return root;
    }
    private void insertIntoBST_util(TreeNode root, int val) {
    	if(root.val<val) {
    		if(root.right==null) {
    			root.right = new TreeNode(val);
    		}else {
    			insertIntoBST_util(root.right, val);
    		}
    	}else {
    		if(root.left==null) {
    			root.left = new TreeNode(val);
    		}else {
    			insertIntoBST_util(root.left, val);
    		}
    	}
    }
}
