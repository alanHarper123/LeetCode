package leetCode.problems._637_Average_of_Levels_in_Binary_Tree;

import java.util.ArrayList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	public List<Double> averageOfLevels(TreeNode root) {
		ArrayList<Double> levelSum_Average = new ArrayList<>();
		ArrayList<Integer> levelCount = new ArrayList<>();
		if(root!=null) {
			preOrder(root, levelSum_Average, levelCount, 0);
			for (int i = 0; i < levelSum_Average.size(); i++) {
				levelSum_Average.set(i, levelSum_Average.get(i)/levelCount.get(i));
			}
		}
		return levelSum_Average;
	}
	private void preOrder(TreeNode root,ArrayList<Double> levelSum_Average,
			ArrayList<Integer> levelCount,int level) {
		if(level<levelCount.size()) {
			levelCount.set(level, levelCount.get(level)+1);
			levelSum_Average.set(level, levelSum_Average.get(level)+root.val);
		}else {
			levelCount.add(1);
			levelSum_Average.add((double) root.val);
		}
		if(root.left!=null)
			preOrder(root.left, levelSum_Average, levelCount, level+1);
		if(root.right!=null)
			preOrder(root.right, levelSum_Average, levelCount, level+1);
	}
}
