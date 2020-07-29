package leetCode.problems._889_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
    	return constructFromPrePost(pre, post, 0, 0, pre.length);
    }
    private TreeNode constructFromPrePost(int[] pre, int[] post,int starte,
    		int startt,
    		int endt) {
    	if(startt>=endt)
    		return null;
    	TreeNode root = new TreeNode(pre[starte]);
        if(endt-startt==1) 
        	return root;
        int leftVal = pre[starte+1];
        int j = startt;
        for (; j < endt-1; j++) {
			if(post[j]==leftVal)
				break;
		}
        root.left = constructFromPrePost(pre, post,starte+1,startt,j+1);
        root.right = constructFromPrePost(pre, post,j+1-startt+starte+1, j+1, endt-1);
        return root;
    }
}
/*
889. Construct Binary Tree from Preorder and Postorder Traversal
Medium

Return any binary tree that matches the given preorder and postorder traversals.

Values in the traversals pre and post are distinct positive integers.

 

Example 1:

Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

 

Note:

    1 <= pre.length == post.length <= 30
    pre[] and post[] are both permutations of 1, 2, ..., pre.length.
    It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
