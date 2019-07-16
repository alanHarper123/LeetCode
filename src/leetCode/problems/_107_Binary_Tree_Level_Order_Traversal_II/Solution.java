package leetCode.problems._107_Binary_Tree_Level_Order_Traversal_II;

import java.util.LinkedList;
import java.util.List;
import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	LinkedList<List<Integer>> result = new LinkedList<>();
    	levelOrder(result, root, 0);
        return result;
    }
    private void levelOrder(LinkedList<List<Integer>> result, TreeNode root, int level) {
    	if(root == null)
    		return;
    	if(result.size() == level) {
    		List<Integer> newList = new LinkedList<>();
    		newList.add(root.val);
    		result.addFirst(newList);
    	}else 
			result.get(result.size()-level-1).add(root.val);
		levelOrder(result, root.left, level+1);
		levelOrder(result, root.right, level+1);
    }
}
