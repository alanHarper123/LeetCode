package leetCode.problems._236_Lowest_Common_Ancestor_of_a_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	result=null;
        recursiveFind(root, p, q);
        return result;
    }
    private boolean recursiveFind(TreeNode root, TreeNode p, TreeNode q) {
    	if(root==null||result!=null)
    		return false;
    	int count=0;
    	if(root.val==p.val||root.val==q.val)
    		count++;
    	if(recursiveFind(root.left, p, q))
    		count++;
    	if(count==2)
    		result=root;
    	if(recursiveFind(root.right, p, q))
    		count++;
    	if(count==2)
    		result=root;
    	return count>0;
    }
}
