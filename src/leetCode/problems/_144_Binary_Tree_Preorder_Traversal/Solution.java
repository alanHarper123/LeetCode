package leetCode.problems._144_Binary_Tree_Preorder_Traversal;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorderTraversal(root,result);
        return result;
    }
    private void preorderTraversal(TreeNode root,List<Integer> result) {
    	if(root==null)
    		return;
    	result.add(root.val);
    	preorderTraversal(root.left,result);
    	preorderTraversal(root.right,result);
    }
}
