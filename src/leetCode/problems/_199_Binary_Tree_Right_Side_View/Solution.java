package leetCode.problems._199_Binary_Tree_Right_Side_View;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    	 List<Integer> result = new LinkedList<>();
    	 rightSideView(root.right,1, result);
    	 return result;
    	 
    }
    private void rightSideView(TreeNode root,int level,List<Integer> result) {
    	if(root==null)
    		return;
    	if(level>result.size())
    		result.add(root.val);
    	rightSideView(root.right, level+1, result);
    	rightSideView(root.left, level+1, result);
    }
}
