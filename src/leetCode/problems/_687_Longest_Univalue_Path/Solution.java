package leetCode.problems._687_Longest_Univalue_Path;

import jdk.javadoc.internal.doclets.toolkit.taglets.ReturnTaglet;
import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int maxL;
    public int longestUnivaluePath(TreeNode root) {
        maxL = 0;
        longestUnivaluePath(root, 0);
        return maxL;
    }
    private int longestUnivaluePath(TreeNode root,int preV) {
    	if(root!=null) {
    		int leftP = longestUnivaluePath(root.left, root.val);
        	int rightP = longestUnivaluePath(root.right, root.val);
        	if(leftP+rightP>maxL)
        		maxL = leftP+rightP;
        	if(root.val==preV)
        		return Math.max(leftP, rightP)+1;
    	}
    	return 0;
    }
}
/*
 Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

 

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5

Output: 2

 

Example 2:

Input:

              1
             / \
            4   5
           / \   \
          4   4   5

Output: 2

 

Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

 */
