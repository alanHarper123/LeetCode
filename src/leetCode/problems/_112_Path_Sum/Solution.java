package leetCode.problems._112_Path_Sum;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root==null) {
			return false;
		}
        sum -= root.val;
        if(root.left==null&&root.right==null) {
        	if(sum==0)
        		return true;
        	return false;
        }

        if(root.left!=null&&hasPathSum(root.left, sum))
        	return true;
        if(root.right!=null&&hasPathSum(root.right, sum))
        	return true;
        return false;
    }
}
