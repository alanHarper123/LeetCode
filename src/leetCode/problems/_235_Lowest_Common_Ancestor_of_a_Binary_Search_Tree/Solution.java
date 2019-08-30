package leetCode.problems._235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private TreeNode result=null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursiveFind(root, p, q);
        return result;
    }
    private boolean recursiveFind(TreeNode root, TreeNode p, TreeNode q) {
    	if(result!=null||root==null)
    		return false;
    	int count = 0;
    	if(root.val == p.val||root.val == q.val) 
    		count++;
    	
    	if(recursiveFind(root.right, p, q))
    		count++;
    	if(count==2) {
    		result = root;
    		return true;
    	}
    	if(recursiveFind(root.left, p, q))
    		count++;	
		if(count==2)
			result = root;
    	
    	return count>0;	
    }
}
