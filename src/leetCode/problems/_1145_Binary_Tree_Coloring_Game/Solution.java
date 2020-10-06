package leetCode.problems._1145_Binary_Tree_Coloring_Game;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode xNode = findNode(root, x);
        int leftC = countNodes(xNode.left);
        if(leftC>n-leftC)
        	return true;
        int rightC = countNodes(xNode.right);
        if(rightC>n-rightC)
        	return true;
        if(n-leftC-rightC-1>leftC+rightC+1)
        	return true;
        return false;
    }
    public TreeNode findNode(TreeNode root, int val) {
    	if(root==null)
    		return null;
    	if(root.val==val)
    		return root;
    	TreeNode result = findNode(root.left, val);
    	if(result!=null)
    		return result;
    	return findNode(root.right, val);
    }
    private int countNodes(TreeNode root) {
    	if(root==null)
    		return 0;
    	return countNodes(root.left)+countNodes(root.right)+1;
    }
}
/*
1145. Binary Tree Coloring Game
Medium

Two players play a turn based game on a binary tree.  We are given the root of this binary tree, and the number of nodes n in the tree.  n is odd, and each node has a distinct value from 1 to n.

Initially, the first player names a value x with 1 <= x <= n, and the second player names a value y with 1 <= y <= n and y != x.  The first player colors the node with value x red, and the second player colors the node with value y blue.

Then, the players take turns starting with the first player.  In each turn, that player chooses a node of their color (red if player 1, blue if player 2) and colors an uncolored neighbor of the chosen node (either the left child, right child, or parent of the chosen node.)

If (and only if) a player cannot choose such a node in this way, they must pass their turn.  If both players pass their turn, the game ends, and the winner is the player that colored more nodes.

You are the second player.  If it is possible to choose such a y to ensure you win the game, return true.  If it is not possible, return false.

 

Example 1:

Input: root = [1,2,3,4,5,6,7,8,9,10,11], n = 11, x = 3
Output: true
Explanation: The second player can choose the node with value 2.

 

Constraints:

    root is the root of a binary tree with n nodes and distinct node values from 1 to n.
    n is odd.
    1 <= x <= n <= 100

*/