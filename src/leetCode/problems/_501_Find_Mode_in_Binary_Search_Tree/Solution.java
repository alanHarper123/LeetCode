package leetCode.problems._501_Find_Mode_in_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

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
class Solution {

	public int[] findMode(TreeNode root) {
		HashMap<Integer, Integer> valToCounts = new HashMap<>();
		if(root!=null) 
			findModeUtil(root, valToCounts);
		else 
			return new int[0];
		Set<Entry<Integer, Integer>> entrys = valToCounts.entrySet();
		int maxFr = 0;
		int count = 1;
		for (Entry<Integer, Integer>entry:entrys) {
			if(entry.getValue()>maxFr) {
				count=1;
				maxFr=entry.getValue();
			}
			else if(entry.getValue()==maxFr)
				count++;
		}
		int[] result = new int[count];
		for (Entry<Integer, Integer>entry:entrys) {
			if(entry.getValue()==maxFr)
				result[--count] = entry.getKey();
		}
		return result;
	}
	private void findModeUtil(TreeNode root,
			HashMap<Integer, Integer> valToCounts) {
		if(root==null)
			return;
		int count = valToCounts.getOrDefault(root.val, 0);
		valToCounts.put(root.val, count+1);
		findModeUtil(root.left,valToCounts);
		findModeUtil(root.right,valToCounts);
	}
}
