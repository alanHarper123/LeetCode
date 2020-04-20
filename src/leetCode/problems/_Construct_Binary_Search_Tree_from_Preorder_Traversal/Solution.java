package leetCode.problems._Construct_Binary_Search_Tree_from_Preorder_Traversal;

import java.util.LinkedList;

import leetCode.problems.commonUtil.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
    	if(preorder==null||preorder.length==0)
    		return null;
    	LinkedList<TreeNode> leftBones = new LinkedList<>();
    	TreeNode root = new TreeNode(preorder[0]);
    	leftBones.add(root);
        for (int i = 1; i < preorder.length; i++) {
        	TreeNode newLeft = new TreeNode(preorder[i]);
        	
			if(newLeft.val<leftBones.peekLast().val) {
				leftBones.peekLast().left=newLeft;	
			}else {
	        	TreeNode pre = leftBones.pollLast();
	        	TreeNode rooti = leftBones.peekFirst();
	        	TreeNode leftBone = leftBones.peekLast();
	        	while (leftBone!=null&&newLeft.val>leftBone.val) {
	        		pre = leftBone;
	        		leftBones.pollLast();
	        		leftBone = leftBones.peekLast();
	        	}
	        	if(leftBone!=null)
	        		pre.right = newLeft;
	        	else
	        		rooti.right = newLeft;
			}
			leftBones.add(newLeft);
		}
        return root;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		solution.bstFromPreorder(null);
	}
}
