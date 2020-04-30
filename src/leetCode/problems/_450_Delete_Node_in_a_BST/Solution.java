package leetCode.problems._450_Delete_Node_in_a_BST;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
        	return null;
        return deleteNodeUtil(root,root,false, null, key);
    }
    private TreeNode deleteNodeUtil(TreeNode root,TreeNode rooti,boolean isLeftChild, TreeNode parent, int key) {
    	if(rooti==null)
    		return root;
    	if(key<rooti.val) 
    		return deleteNodeUtil(root,rooti.left,true, rooti, key);
    	else if(key>rooti.val) 
    		return deleteNodeUtil(root,rooti.right,false, rooti, key);
    	else {
    		if(rooti.left!=null) {
    			if(rooti.left.right!=null) {
    				rooti.val=deleteMax(rooti.left, rooti);
    			}else {
    				rooti.val = rooti.left.val;
    				rooti.left = rooti.left.left;
    			}
    			return root;
    		}else if(rooti.right!=null) {
    			if(rooti.right.left!=null) {
    				rooti.val=deleteMin(rooti.right, rooti);
    			}else {
    				rooti.val = rooti.right.val;
    				rooti.right = rooti.right.right;
    			}
    			return root;
    		}else {
    			if(parent!=null) {
    				if(isLeftChild)
    					parent.left=null;
    				else 
						parent.right=null;
    				return root;
					
    			}else 
					return null;
				
    		}
    	}
    }
    private int deleteMax(TreeNode root, TreeNode parent) {
    	while (root.right!=null) {
			parent = root;
			root = root.right;
		}
    	parent.right = root.left;
    	return root.val;
    }
    private int deleteMin(TreeNode root,TreeNode parent) {
    	while (root.left!=null) {
			parent = root;
			root = root.left;
		}
    	parent.left = root.right;
    	return root.val;
    }
}
