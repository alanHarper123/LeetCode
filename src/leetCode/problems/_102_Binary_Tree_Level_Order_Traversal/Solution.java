package leetCode.problems._102_Binary_Tree_Level_Order_Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<>();
    	levelOrder(result, root, 0);
        return result;
    }
    private void levelOrder(List<List<Integer>> result, TreeNode root, int level) {
    	if(root == null)
    		return;
    	if(result.size() == level) {
    		List<Integer> newList = new LinkedList<>();
    		newList.add(root.val);
    		result.add(newList);
    	}else 
			result.get(level).add(root.val);
		levelOrder(result, root.left, level+1);
		levelOrder(result, root.right, level+1);
    }
}
