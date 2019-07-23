package leetCode.problems._145_Binary_Tree_Postorder_Traversal;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderTraversal(root,result);
        return result;        
    }
    private void preorderTraversal(TreeNode root,List<Integer> result) {
    	if(root==null)
    		return;
    	preorderTraversal(root.left,result);
    	preorderTraversal(root.right,result);
    	result.add(root.val);
    }
}
