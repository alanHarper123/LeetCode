package leetCode.problems._863_All_Nodes_Distance_K_in_Binary_Tree;


import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		List<Integer> res = new LinkedList<>();
		distanceKUtil(target, K, 0, res);
		distanceToTarget(root, K, target, res);
		return res;
	}
	private void distanceKUtil(TreeNode root, int K,
			int dis, List<Integer> res) {
		if(root==null)
			return;
		if(dis==K) {
			res.add(root.val);
			return;
		}
		distanceKUtil(root.left, K, dis+1, res);
		distanceKUtil(root.right, K, dis+1, res);
	}
	private int distanceToTarget(TreeNode root, int K,
			TreeNode target, List<Integer> res) {
		if(root==null)
			return -1;
		if(root==target)
			return 0;
		int leftD = distanceToTarget(root.left, K, target, res);
		if(leftD<0) {
			int rightD = distanceToTarget(root.right, K, target, res);
			if(rightD<0)
				return -1;
			else if(rightD+1==K){
				res.add(root.val);
			}else if(rightD+1<K) {
				distanceKUtil(root.left, K-rightD-1, 1, res);
				return rightD+1;
			}
			return K;
		}else {
			if(leftD+1==K) {
				res.add(root.val);
			}else if(leftD+1<K) {
				distanceKUtil(root.right, K-leftD-1, 1, res);
				return leftD+1;
			}
			return K;	
		}
	}
}
/*
863. All Nodes Distance K in Binary Tree
Medium

We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.

 

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.



Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

 

Note:

    The given tree is non-empty.
    Each node in the tree has unique values 0 <= node.val <= 500.
    The target node is a node in the tree.
    0 <= K <= 1000.
 */