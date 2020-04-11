package leetCode.problems._Diameter_of_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
	private int maxPath;
    public int diameterOfBinaryTree(TreeNode root) {
        maxPath = 0;
        if(root==null)
        	return maxPath;
        diameterOfBinaryTreeUtil(root);
        return maxPath;
    }
    private Integer diameterOfBinaryTreeUtil(TreeNode root) {
    	if(root==null)
    		return 0;
    	Integer leftPath = diameterOfBinaryTreeUtil(root.left);
    	Integer rightPath = diameterOfBinaryTreeUtil(root.right);
    	Integer nodeMaxPath = Math.max(leftPath, rightPath);
    	if(nodeMaxPath>maxPath)
    		maxPath = nodeMaxPath;
    	if(leftPath!=0&&rightPath!=0&&leftPath+rightPath>maxPath)
    		maxPath = leftPath+rightPath;
    	return nodeMaxPath+1;
    }
}
