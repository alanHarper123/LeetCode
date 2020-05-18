package leetCode.problems._515_Find_Largest_Value_in_Each_Tree_Row;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public List<Integer> largestValues(TreeNode root) {
		LinkedList<Integer> largestVals = new LinkedList<>();
		if(root==null)
			return largestVals;
		LinkedList<TreeNode> bfsFrontiers = new LinkedList<>();
		bfsFrontiers.add(root);
		int b_max,b_width;
		while (!bfsFrontiers.isEmpty()) {
			b_max = Integer.MIN_VALUE;
			b_width = bfsFrontiers.size();
			while (b_width>0) {
				b_width--;
				TreeNode bfsFrontier = bfsFrontiers.pollFirst();
				if(bfsFrontier.val>b_max)
					b_max = bfsFrontier.val;
				if(bfsFrontier.left!=null)
					bfsFrontiers.add(bfsFrontier.left);
				if(bfsFrontier.right!=null)
					bfsFrontiers.add(bfsFrontier.right);
			}
			largestVals.add(b_max);
		}
		return largestVals;
	}
}
