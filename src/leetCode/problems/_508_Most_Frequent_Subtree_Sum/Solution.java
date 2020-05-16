package leetCode.problems._508_Most_Frequent_Subtree_Sum;

import java.awt.image.RescaleOp;
import java.util.HashMap;
import java.util.Map.Entry;

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
public class Solution {
	private HashMap<Integer, Integer> valtoCounts;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null)
        	return new int[0];
        valtoCounts = new HashMap<>();
        postOrder(root, valtoCounts);
        int maxFr = 0;
        int maxFrC = 1;
        for(Entry<Integer, Integer>entry:valtoCounts.entrySet()) {
        	if(entry.getValue()>maxFr) {
        		maxFr = entry.getValue();
        		maxFrC = 1;
        	}else if(entry.getValue()==maxFr) {
        		maxFrC++;
        	}
        }
        int[] maxFrSums = new int[maxFrC];
        for(Entry<Integer, Integer>entry:valtoCounts.entrySet()) {
        	if(entry.getValue()==maxFr) {
        		maxFrSums[--maxFrC] = entry.getKey();
        	}
        }
        return maxFrSums;
    }
    private int postOrder(TreeNode root, HashMap<Integer, Integer> valtoCounts){
    	int sum = 0;
    	if(root.left!=null)
    		sum+=postOrder(root.left,valtoCounts);
    	if(root.right!=null)
    		sum+=postOrder(root.right,valtoCounts);
    	sum+=root.val;
    	int count = valtoCounts.getOrDefault(sum, 0);
    	valtoCounts.put(sum, count+1);
    	return sum;
    }
}
