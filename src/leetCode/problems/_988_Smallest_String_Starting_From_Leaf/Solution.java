package leetCode.problems._988_Smallest_String_Starting_From_Leaf;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public String smallestFromLeaf(TreeNode root) {
		return smallestFromLeafUtil(root,new StringBuilder()).toString();
	}
	private StringBuilder smallestFromLeafUtil(TreeNode root,StringBuilder stringBuilder) {
		char c = (char)(root.val+'a');
		StringBuilder stringBuilder2 = new StringBuilder();
		if(root.left==null||root.right==null) {
			if(root.left==null&&root.right==null) {
				return stringBuilder2.append(c);
			}
			stringBuilder.append(c);
			if(root.left==null) {
				stringBuilder2 = smallestFromLeafUtil(root.right,stringBuilder);
				stringBuilder.deleteCharAt(stringBuilder.length()-1);
				return stringBuilder2.append(c);
			}
			stringBuilder2 = smallestFromLeafUtil(root.left,stringBuilder);
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
			return stringBuilder2.append(c);
		}
		stringBuilder.append(c);
		StringBuilder stringBuilderR = smallestFromLeafUtil(root.right,stringBuilder);
		StringBuilder stringBuilderL = smallestFromLeafUtil(root.left,stringBuilder);
		stringBuilderR.append(stringBuilder.reverse());
		stringBuilderL.append(stringBuilder);
		stringBuilder.reverse();
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		if(stringBuilderR.compareTo(stringBuilderL)<0) 
			return stringBuilderR.delete(stringBuilderR.length()-stringBuilder.length(), stringBuilderR.length());
		else 
			return stringBuilderL.delete(stringBuilderL.length()-stringBuilder.length(), stringBuilderL.length());
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(1);
		System.out.println(new Solution().smallestFromLeaf(root));
	}
}
/*
988. Smallest String Starting From Leaf
Medium

Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)

 

Example 1:

Input: [0,1,2,3,4,3,4]
Output: "dba"

Example 2:

Input: [25,1,3,1,3,0,2]
Output: "adz"

Example 3:

Input: [2,2,1,null,1,0,null,0]
Output: "abc"

 

Note:

    The number of nodes in the given tree will be between 1 and 8500.
    Each node in the tree will have a value between 0 and 25.
 */