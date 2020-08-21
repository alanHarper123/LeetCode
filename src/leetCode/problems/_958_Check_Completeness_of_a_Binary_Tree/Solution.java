package leetCode.problems._958_Check_Completeness_of_a_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	boolean isOutOfRange;
    public boolean isCompleteTree(TreeNode root) {
        boolean[] isNumTaken = new boolean[100];
        isOutOfRange = false;
        setNum(root, 0, isNumTaken);
        if(isOutOfRange)
        	return false;
        boolean isContinued = true;
        for (int i = 0; i < isNumTaken.length; i++) {
			if(isNumTaken[i]) {
				if(!isContinued)
					return false;
			}else 
				isContinued = false;
		}
        return true;
    }
    private void setNum(TreeNode root,int num,boolean[] isNumTaken) {
    	if(root==null||isOutOfRange)
    		return;
    	if(num>=isNumTaken.length) {
    		isOutOfRange = true;
    		return;
    	}
    	isNumTaken[num] = true;
    	setNum(root.left, 2*num+1, isNumTaken);
    	setNum(root.right, 2*num+2, isNumTaken);
    }
}
/*
958. Check Completeness of a Binary Tree
Medium

Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

 

Example 1:

Input: [1,2,3,4,5,6]
Output: true
Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:

Input: [1,2,3,4,5,null,7]
Output: false
Explanation: The node with value 7 isn't as far left as possible.

 

Note:

    The tree will have between 1 and 100 nodes.
 */