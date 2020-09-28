package leetCode.problems._1110_Delete_Nodes_And_Return_Forest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        LinkedList<TreeNode> res = new LinkedList<>();
        HashSet<Integer> deleteSet = new HashSet<>();
        for(int e:to_delete)
        	deleteSet.add(e);
        delNodes_TreeRoot(res, root, deleteSet);
        return res;
    }
    private TreeNode delNodes_TreeNodes(LinkedList<TreeNode> res,
    		TreeNode root,HashSet<Integer> deleteSet) {
    	if(root==null)
    		return root;
    	if(deleteSet.contains(root.val)) {
    		delNodes_TreeRoot(res, root.left, deleteSet);
    		delNodes_TreeRoot(res, root.right, deleteSet);
    		return null;
    	}else {
    		root.left = delNodes_TreeNodes(res, root.left, deleteSet);
    		root.right = delNodes_TreeNodes(res, root.right, deleteSet);
    		return root;
    	}
    	
    }
    private void delNodes_TreeRoot(LinkedList<TreeNode> res,
    		TreeNode root,HashSet<Integer> deleteSet) {
    	if(root==null)
    		return;
    	if(!deleteSet.contains(root.val)) {
    		res.add(root);
    		root.left = delNodes_TreeNodes(res, root.left, deleteSet);
    		root.right = delNodes_TreeNodes(res, root.right, deleteSet);
    	}else {
    		delNodes_TreeRoot(res, root.left, deleteSet);
    		delNodes_TreeRoot(res, root.right, deleteSet);
    	}   	
    }
}
/*
1110. Delete Nodes And Return Forest
Medium

Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]

 

Constraints:

    The number of nodes in the given tree is at most 1000.
    Each node has a distinct value between 1 and 1000.
    to_delete.length <= 1000
    to_delete contains distinct values between 1 and 1000.
*/