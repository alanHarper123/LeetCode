package leetCode.problems._114_Flatten_Binary_Tree_to_Linked_List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public void flatten(TreeNode root) {
        while (root!=null) {
        	if(root.left!=null) {
        		TreeNode temp = root.right;
        		TreeNode runner = root.left;
        		root.right = root.left;
        		root.left = null;
        		while (runner.left==null&&runner.right!=null) {
        			root = runner;
        			runner=runner.right;
				}
        		while (runner.right!=null) {
        			runner=runner.right;
				}
        		runner.right = temp;
        	}
        	else
				root = root.right;
		}
    }
}
