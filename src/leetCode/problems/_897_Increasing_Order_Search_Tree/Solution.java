package leetCode.problems._897_Increasing_Order_Search_Tree;

import java.util.Iterator;
import java.util.LinkedList;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> res = new LinkedList<>();
        inorder(root, res);
        TreeNode newRoot = res.pollFirst();
        Iterator<TreeNode> iter = res.iterator();
        TreeNode runner = newRoot;
        while (iter.hasNext()) {
			runner.right = iter.next();
			runner = runner.right;
			runner.left = null;
		}
        return newRoot;
    }
    private void inorder(TreeNode root,LinkedList<TreeNode> res){
    	if(root==null)
    		return;
    	inorder(root.left, res);
    	res.add(root);
    	inorder(root.right, res);
    }
}
