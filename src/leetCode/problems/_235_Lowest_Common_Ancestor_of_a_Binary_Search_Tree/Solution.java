package leetCode.problems._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursiveFind(root, p, q);
        return result;
    }
    private void recursiveFind(TreeNode root, TreeNode p, TreeNode q) {
    	if(result!=null||root==null)
    		return;
    	
    	if((root.val>p.val&&root.val>q.val)) {
    		recursiveFind(root.left, p, q);
    		return;
    	}
    		
    	if((root.val<p.val&&root.val<q.val)) {
    		recursiveFind(root.right, p, q);
    		return;
    	}
		result = root;
    }
}
