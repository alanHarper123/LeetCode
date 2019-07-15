package leetCode.problems._104_Maximum_Depth_of_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private int maximumDepth;
    public int maxDepth(TreeNode root) {
        maximumDepth=0;
        maxDepth(root,0);
        return maximumDepth;
    }
    private void maxDepth(TreeNode root, int level) {
    	if(root == null) {
    		if(level>maximumDepth)
    			maximumDepth = level;
    		return;
    	}
    	maxDepth(root.left,level+1);
    	maxDepth(root.right,level+1);
    }
}
