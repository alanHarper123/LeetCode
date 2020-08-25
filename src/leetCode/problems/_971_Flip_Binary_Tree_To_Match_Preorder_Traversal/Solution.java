package leetCode.problems._971_Flip_Binary_Tree_To_Match_Preorder_Traversal;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	boolean failed;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        failed = false;
        int[] indexs = new int[voyage.length+1];
        for (int i = 0; i < voyage.length; i++) {
			indexs[voyage[i]] = i;
		}
        List<Integer> res = new LinkedList<>();
        travel(res, root, voyage, 0, voyage.length, indexs);
        if(failed) {
        	res.clear();
        	res.add(-1);
        }
        return res;
        
    }
    private void travel(List<Integer> res,TreeNode root, int[] voyage,int start, int end,int[] indexs) {

    	if(start>=end||root.val != voyage[start]) {
    		failed = true;
    		return;	
    	}
		if(root.left!=null) {	
			if(root.right!=null) {
				int newEnd = indexs[root.right.val];
				if(newEnd>=end||newEnd<start) {
					failed = true;
					return;
				}
				if(newEnd!=start+1) {
					travel(res,root.left, voyage, start+1, newEnd, indexs);	
					if (failed) {
						return;
					}
					travel(res,root.right, voyage, newEnd, end, indexs);
				}else {
					newEnd = indexs[root.left.val];
					if(newEnd>=end||newEnd<start) {
						failed = true;
						return;
					}
					res.add(root.val);
					travel(res,root.right, voyage, start+1, newEnd, indexs);	
					if (failed) {
						return;
					}
					travel(res,root.left, voyage, newEnd, end, indexs);
				}	
			}else 
				travel(res,root.left, voyage, start+1, end, indexs);	
		}else {
			if(root.right!=null) 
				travel(res,root.right, voyage, start+1, end, indexs);	
		}
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
		System.out.println(new Solution().flipMatchVoyage(root, new int[] {1,3,2}));
	}
}
/*
971. Flip Binary Tree To Match Preorder Traversal
Medium

Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

A node in this binary tree can be flipped by swapping the left child and the right child of that node.

Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

If we cannot do so, then return the list [-1].

 

Example 1:

Input: root = [1,2], voyage = [2,1]
Output: [-1]

Example 2:

Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]

Example 3:

Input: root = [1,2,3], voyage = [1,2,3]
Output: []

 

Note:

    1 <= N <= 100
 */