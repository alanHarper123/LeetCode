package leetCode.problems._Check_If_a_String_Is_a_Valid_Sequence_from_Root_to_Leaves;

import leetCode.problems.commonUtil.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
    	if(root==null) {
    		return arr.length==0;
    	}
        return isValidSequenceUtil(root, 0, arr);
    }
    private boolean isValidSequenceUtil(TreeNode currentNode,int index,int[] arr) {
    	if(currentNode==null)
    		return false;
    	if(currentNode.val!=arr[index++])
			return false;
    	if(index==arr.length)
    		return currentNode.left==null&&currentNode.right==null;
    	return isValidSequenceUtil(currentNode.left, index, arr)
    			||isValidSequenceUtil(currentNode.right, index, arr);
    }
}
