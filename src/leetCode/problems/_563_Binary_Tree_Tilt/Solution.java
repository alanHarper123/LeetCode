package leetCode.problems._563_Binary_Tree_Tilt;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int tilSum;
    public int findTilt(TreeNode root) {
        tilSum = 0;
        findTiltUtil(root);
        return tilSum;
    }
    private int findTiltUtil(TreeNode root) {
    	if(root==null)
    		return 0;
    	int lefSum = findTiltUtil(root.left);
    	int rightSum = findTiltUtil(root.right);
    	tilSum+=Math.abs(lefSum-rightSum);
    	return lefSum+rightSum+root.val;
    }
}
