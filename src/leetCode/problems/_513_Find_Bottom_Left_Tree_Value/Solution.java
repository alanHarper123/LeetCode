package leetCode.problems._513_Find_Bottom_Left_Tree_Value;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int curLevel;
	private int curLeftMost;
    public int findBottomLeftValue(TreeNode root) {
    	curLevel = 0;
    	curLeftMost = 0;
        inOrder(root, 1);
        return curLeftMost;
    }
    private void inOrder(TreeNode root,int level) {
    	if(root.left==null) {
    		if(root.right==null&&level>curLevel) {
    			curLevel = level;
    			curLeftMost = root.val;
    		}
    	}else {
    		inOrder(root.left, level+1);
    	}
    	if(root.right!=null)
    		inOrder(root.right, level+1);
    }
}
