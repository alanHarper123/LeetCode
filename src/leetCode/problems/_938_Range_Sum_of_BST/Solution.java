package leetCode.problems._938_Range_Sum_of_BST;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root==null)
        	return 0;
        int res = 0;
        if(root.val<L) {
        	res+=rangeSumBST(root.right, L, R);
        }else if(root.val>R){
        	res+=rangeSumBST(root.left, L, R);
        }else {
        	res+=root.val;
        	res+=rangeSumBST(root.right, L, R);
        	res+=rangeSumBST(root.left, L, R);
        }
        return res;
    }
}
