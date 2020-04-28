package leetCode.problems._437_Path_Sum_III;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

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
    public int pathSum(TreeNode root, int sum) {
    	if(root==null)
    		return 0;
        return pathSumUtil(new LinkedList<>(), root, sum);
    }
    private int pathSumUtil(LinkedList<Integer> pathsum, TreeNode root, int sum) {
    	int size = pathsum.size();
    	int count = 0;
    	for (int i = 0; i < size; i++) {
			int sumi = pathsum.pollFirst()+root.val;
			if(sumi==sum)
				count++;
			pathsum.add(sumi);
		}
    	pathsum.add(root.val);
    	if(root.val==sum)
    		count++;
    	if(root.left!=null) {
    		if(root.right==null)
    			count+=pathSumUtil(pathsum,root.left, sum);
    		else {
    			LinkedList<Integer> pathsumFL = new LinkedList<>();
    			for (Integer i:pathsum) {
					pathsumFL.add(i);
				}
    			count+=pathSumUtil(pathsumFL,root.left, sum);
    		}
    	}
    	if(root.right!=null)
    		count+=pathSumUtil(pathsum,root.right, sum);
    	return count;
    		
    }
}
