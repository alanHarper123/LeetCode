package leetCode.problems._919_Complete_Binary_Tree_Inserter;

import java.util.ArrayList;

import leetCode.problems.commonUtil.TreeNode;

public class CBTInserter {
	ArrayList<TreeNode> nodes = new ArrayList<>();
    public CBTInserter(TreeNode root) {
        addNodes(root, 0);
    }
    private void addNodes(TreeNode root, int index) {
    	while (index>=nodes.size()) {
			nodes.add(null);
		}
    	nodes.set(index, root);
    	if(root.left!=null)
    		addNodes(root.left, 2*index+1);
    	if(root.right!=null)
    		addNodes(root.right, 2*index+2);
    }
    public int insert(int v) {
        int index = nodes.size();
        TreeNode newNode = new TreeNode(v);
        nodes.add(newNode);
        TreeNode pNode = nodes.get((index-1)/2);
        if((index&1)==1) {
        	pNode.left = newNode;
        }else {
        	pNode.right = newNode;
        }
        return pNode.val;
    }
    
    public TreeNode get_root() {
        return nodes.get(0);
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */

/*
919. Complete Binary Tree Inserter
Medium

A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

    CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
    CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, and returns the value of the parent of the inserted TreeNode;
    CBTInserter.get_root() will return the head node of the tree.

 

Example 1:

Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
Output: [null,1,[1,2]]

Example 2:

Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
Output: [null,3,4,[1,2,3,4,5,6,7,8]]

 

Note:

    The initial given tree is complete and contains between 1 and 1000 nodes.
    CBTInserter.insert is called at most 10000 times per test case.
    Every value of a given or inserted node is between 0 and 5000.
 */