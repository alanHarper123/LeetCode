package leetCode.problems._113_Path_Sum_II;

import java.util.LinkedList;
import java.util.List;


import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		LinkedList<List<Integer>> results = new LinkedList<>();
		pathSumUtil(root, sum, results, new LinkedList<>());
		return results;
	}
	private void pathSumUtil(TreeNode root, int sum,
			List<List<Integer>> results, LinkedList<Integer> result) {
		if (root==null) 
			return;
		sum -= root.val;
		result.add(root.val);
		if(root.left==null&&root.right==null&&sum==0) 
			results.add(new LinkedList<Integer>(result));
		
		if(root.left!=null)
			pathSumUtil(root.left, sum,results,result);
		if(root.right!=null)
			pathSumUtil(root.right, sum,results,result);
		result.removeLast();
		return;
	}
}
