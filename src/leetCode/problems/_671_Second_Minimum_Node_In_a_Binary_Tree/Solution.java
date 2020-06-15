package leetCode.problems._671_Second_Minimum_Node_In_a_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null)
        	return -1;
        return findSecondMinimumValueUtil(root, root.val);
    }
    private int findSecondMinimumValueUtil(TreeNode root, int min) {
    	if(root==null)
    		return -1;
    	if(root.val == min) {
    		int secondMinLeft = findSecondMinimumValueUtil(root.left,min);
    		int secondMinRight = findSecondMinimumValueUtil(root.right,min);
    		if(secondMinLeft==-1)
    			return secondMinRight;
    		if(secondMinRight==-1)
    			return secondMinLeft;
    		return Math.min(secondMinLeft, secondMinRight);
    	}else {
    		return root.val;
    	}
    }
}
