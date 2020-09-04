package leetCode.problems._1022_Sum_of_Root_To_Leaf_Binary_Numbers;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	int res;
    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        calulate(root, 0);
        return res;
    }
    private void calulate(TreeNode root, int val) {
    	val+=root.val;
    	if(root.left==null&&root.right==null) {
    		res+=val;
    		return;
    	}
    	val<<=1;
    	if(root.left!=null) 
    		calulate(root.left, val);
    	if(root.right!=null)
    		calulate(root.right, val);
    }
}
