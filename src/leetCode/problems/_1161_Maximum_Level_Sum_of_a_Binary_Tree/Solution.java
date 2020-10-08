package leetCode.problems._1161_Maximum_Level_Sum_of_a_Binary_Tree;

import java.util.ArrayList;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> levelSums = new ArrayList<>();
        sumLevels(root, 0, levelSums);
        int preIndex = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < levelSums.size(); i++) {
			if(levelSums.get(i)>max) {
				max = levelSums.get(i);
				preIndex = i;
			}
		}
        return preIndex+1;
    }
    private void sumLevels(TreeNode root, int level,ArrayList<Integer> levelSums) {
    	if(root==null)
    		return;
    	if(levelSums.size()==level)
    		levelSums.add(0);
    	levelSums.set(level, levelSums.get(level)+root.val);
    	sumLevels(root.left, level+1, levelSums);
    	sumLevels(root.right, level+1, levelSums);
    }
}
