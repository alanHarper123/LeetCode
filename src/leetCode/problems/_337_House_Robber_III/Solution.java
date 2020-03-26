package leetCode.problems._337_House_Robber_III;

import leetCode.problems.commonUtil.TreeNode;

public /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = new int[2];
        result = robUtil(root);
        return Math.max(result[0], result[1]);
    }
    private int[] robUtil(TreeNode root) {
    	int[] result = new int[2];
        if(root!=null){
        	int[] resultLeft = new int[2];
        	int[] resultRight = new int[2];
        	if(root.left!=null)
        		resultLeft = robUtil(root.left);
        	if(root.right!=null)
        		resultRight = robUtil(root.right);
        	result[0] = Math.max(resultLeft[0], resultLeft[1])
        			+Math.max(resultRight[0], resultRight[1]);
        	result[1] = resultLeft[0]+resultRight[0]+root.val;
        }
        return result;
    }
}
