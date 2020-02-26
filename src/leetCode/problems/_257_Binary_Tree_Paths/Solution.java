package leetCode.problems._257_Binary_Tree_Paths;

import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private List<String> resultList;
    public List<String> binaryTreePaths(TreeNode root) {
        resultList = new LinkedList<>();
        if(root!=null)
        	binaryTreePathsUtil(root, new String());
        return resultList;
    }
    private void binaryTreePathsUtil(TreeNode root, String base) {
		if(root.left==null&&root.right==null) {
			resultList.add(base+root.val);
		}else {
			if(root.left!=null)
				binaryTreePathsUtil(root.left, base+root.val+"->");
			if(root.right!=null)
				binaryTreePathsUtil(root.right, base+root.val+"->");
		}
			
	}
}
