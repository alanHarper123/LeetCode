package leetCode.problems._655_Print_Binary_Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private int maxLevel;
	public List<List<String>> printTree(TreeNode root) {
		ArrayList<List<String>> result = new ArrayList<>();
		if(root!=null) {
			maxLevel = 0;
			int len = calculateArrayLengthAndLevel(root, 1);
			for (int i = 0; i < maxLevel; i++) {
				ArrayList<String> newLevel = new ArrayList<>(len);
				for (int j = 0; j < len; j++) {
					newLevel.add("");
				}
				result.add(newLevel);
			}
			printTreeUtil(result, root, 0, 0, len);
			
		}

		return result;
	}
	private void printTreeUtil(ArrayList<List<String>> result,TreeNode root,int level,int start,int end) {
		if(root==null)
			return;
		List<String> curLevel = result.get(level);
		int mid = start+(end-start)/2;
		curLevel.set(mid, String.valueOf(root.val));
		printTreeUtil(result, root.left, level+1, start, mid);
		printTreeUtil(result, root.right, level+1, mid+1, end);
	}
	private int calculateArrayLengthAndLevel(TreeNode root,int level) {
		if(root==null)
			return 0;
		if(level>maxLevel)
			maxLevel = level;
		return 2*Math.max(calculateArrayLengthAndLevel(root.left, level+1),
				calculateArrayLengthAndLevel(root.right, level+1))+1;
	}
}
