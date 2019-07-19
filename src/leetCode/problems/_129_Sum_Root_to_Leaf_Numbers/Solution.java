package leetCode.problems._129_Sum_Root_to_Leaf_Numbers;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private int sum;
    public int sumNumbers(TreeNode root) {
    	sum=0;
    	sumNumbersUtil(root);
    	return sum;
    }
    private int sumNumbersUtil(TreeNode root) {
        if(root==null)
        	return 0;
        int leftPathsCount = sumNumbersUtil(root.left);
        int rightPathsCount = sumNumbersUtil(root.right);
        int pathsCount = leftPathsCount+rightPathsCount;
        if(pathsCount==0)
        	pathsCount = 1;
        sum+=pathsCount*root.val;
        pathsCount*=10;
        return pathsCount;
    }
}
