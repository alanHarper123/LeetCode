package leetCode.problems._865_Smallest_Subtree_with_all_the_Deepest_Nodes;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int maxLevel;
	private TreeNode resNode;
	private int maxLevelC;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	maxLevelC = 0;
    	maxLevel = -1;
        countTrees(root, 0);
        resNode = null;
        subtreeWithAllDeepestUtil(root, 0);
        return resNode;
    }
    private int countTrees(TreeNode root, int level){
    	if(root==null)
    		return 0;
    	int sum = countTrees(root.left, level+1)
    			+countTrees(root.right, level+1)+1;
    	if(level>maxLevel) {
    		maxLevel = level;
    		maxLevelC = 1;
    	}else if(maxLevel==level)
    		maxLevelC++;
    	return sum;
    }
    private int subtreeWithAllDeepestUtil(TreeNode root,int level) {
    	if(root==null)
    		return 0;
    	int childSum = subtreeWithAllDeepestUtil(root.left, level+1)
    			+subtreeWithAllDeepestUtil(root.right, level+1);
    	if(level==maxLevel)
    		childSum++;
    	if(childSum==maxLevelC&&resNode==null)
    		resNode = root;
    	return childSum;
    }
}
/*
865. Smallest Subtree with all the Deepest Nodes
Medium

Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

 

Example 1:

Input: [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
Explanation:



We return the node with value 2, colored in yellow in the diagram.
The nodes colored in blue are the deepest nodes of the tree.
The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
Both the input and output have TreeNode type.

 

Note:

    The number of nodes in the tree will be between 1 and 500.
    The values of each node are unique.
 */