package leetCode.problems._94_Binary_Tree_Inorder_Traversal;

import java.util.LinkedList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public List<Integer> inorderTraversal(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		inorder(result,root);
		return result;
	}
	private void inorder(LinkedList<Integer> result,TreeNode root) {
		if(root == null)
			return;
		inorder(result,root.left);
		result.add(root.val);
		inorder(result, root.right);
	}
}
