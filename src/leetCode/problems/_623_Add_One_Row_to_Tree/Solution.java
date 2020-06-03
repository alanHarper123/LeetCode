package leetCode.problems._623_Add_One_Row_to_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	int targetLevel;
    public TreeNode addOneRow(TreeNode root, int v, int d) {
    	if(d==1) {
    		TreeNode node = new TreeNode(v);
    		node.left = root;
    		return node;
    	}
        targetLevel = d-1;
        //root != null;
        addOneRowUtil(root, v, 1);
        return root;
    }
    private void addOneRowUtil(TreeNode root, int v, int d) {
    	if(d==targetLevel) {
    		TreeNode left = new TreeNode(v);
    		left.left = root.left;
    		root.left = left;
    		TreeNode right = new TreeNode(v);
    		right.right = root.right;
    		root.right = right;
    	}else if(d<targetLevel) {
    		if(root.left!=null)
    			addOneRowUtil(root.left, v, d+1);
    		if(root.right!=null)
    			addOneRowUtil(root.right, v, d+1);
    	}
    }
}
