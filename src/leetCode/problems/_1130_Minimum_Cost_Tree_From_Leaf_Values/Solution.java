package leetCode.problems._1130_Minimum_Cost_Tree_From_Leaf_Values;

import leetCode.problems.commonUtil.Sorting;

public class Solution {
	class Node{
		Node preNode;
		Node nextNode;
		int val;
		public Node(int val,Node preNode) {
			this.preNode = preNode;
			this.val = val;
		}
		public void deleteSelf() {
			if(preNode!=null)
				preNode.nextNode = nextNode;
			if(nextNode!=null)
				nextNode.preNode = preNode;
		}
	}
    public int mctFromLeafValues(int[] arr) {
        Node pre=null;
        Node[] allNodes = new Node[arr.length];
        int[] indexes = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i], pre);
			if(pre!=null)
				pre.nextNode = cur;
			pre = cur;
			allNodes[i] = cur;
			indexes[i] = i;
		}
        int sum = 0;
        Sorting.sortArr1(arr, indexes, 0, arr.length);
        for (int i = 0; i < indexes.length-1; i++) {
			Node ni = allNodes[indexes[i]];
			if(ni.preNode==null) {
				sum+=ni.val*ni.nextNode.val;
			}else if(ni.nextNode==null) {
				sum+=ni.val*ni.preNode.val;
			}else 
				sum+=ni.val*Math.min(ni.preNode.val, ni.nextNode.val);
			ni.deleteSelf();
		}
        return sum;
    }
}
/*
1130. Minimum Cost Tree From Leaf Values
Medium

Given an array arr of positive integers, consider all binary trees such that:

    Each node has either 0 or 2 children;
    The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
    The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.

Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.

 

Example 1:

Input: arr = [6,2,4]
Output: 32
Explanation:
There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.

    24            24
   /  \          /  \
  12   4        6    8
 /  \               / \
6    2             2   4

 

Constraints:

    2 <= arr.length <= 40
    1 <= arr[i] <= 15
    It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
*/