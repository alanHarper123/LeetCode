package leetCode.problems._103_Binary_Tree_Zigzag_Level_Order_Traversal;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<>();
    	zigzaglevelOrder(result, root, 0);
        return result;
    }
    private void zigzaglevelOrder(List<List<Integer>> result, TreeNode root, int level) {
    	if(root == null)
    		return;
    	if(result.size() == level) {
    		List<Integer> newList = new LinkedList<>();
    		newList.add(root.val);
    		result.add(newList);
    	}else {
    		if(level%2==0)
    			result.get(level).add(root.val);
    		else 
    			((LinkedList<Integer>)result.get(level)).addFirst(root.val);
    	}	
    	zigzaglevelOrder(result, root.left, level+1);
    	zigzaglevelOrder(result, root.right, level+1);
    }
}
