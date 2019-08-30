package leetCode.problems._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root!=null) {
        	if((root.val>p.val&&root.val>q.val))
        		root = root.left;
        	else if((root.val<p.val&&root.val<q.val)) {
        		root = root.right;
        	}
        	else {
        		return root;
        	}
		}
        return root;
    }
}
