package leetCode.problems._95_Unique_Binary_Search_Trees_II;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


//Definition for a binary tree node.
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }

class Solution {
    public List<TreeNode> generateTrees(int n) {
        ArrayList<List<TreeNode>> resultList = new ArrayList<>();
        ArrayList<TreeNode> firstTreeNodes = new ArrayList<>();
        if(n<=0)
        	return firstTreeNodes;
        firstTreeNodes.add(null);
        resultList.add(firstTreeNodes);
        resultList.add(new ArrayList<>(Arrays.asList(new TreeNode(1))));
        if(n<2)
        	return resultList.get(n);
		
        for (int i = 2; i <= n; i++) {
        	ArrayList<TreeNode> newTreeNodes = new ArrayList<>();
        	for (int j = 0; j < i; j++) {
        		for (int k = 0; k < resultList.get(j).size(); k++) {
					for (int l = 0; l < resultList.get(i-1-j).size(); l++) {
						TreeNode newRootkl = new TreeNode(j+1);
						newRootkl.left = copyAndAdd(resultList.get(j).get(k), 0);
						newRootkl.right = copyAndAdd(resultList.get(i-1-j).get(l), j+1);
						newTreeNodes.add(newRootkl);
					}
				}
			}
        	resultList.add(newTreeNodes);
		}
        return resultList.get(resultList.size()-1);
    }
    private TreeNode copyAndAdd(TreeNode root, int addNumber) {
    	if(root==null)
    		return null;
    	TreeNode newRoot = new TreeNode(root.val+addNumber);
    	newRoot.left = copyAndAdd(root.left,addNumber);
    	newRoot.right = copyAndAdd(root.right,addNumber);
    	return newRoot;
    }
    public static void main(String[] args) {
    	int[] tests = {4};
		Solution solution = new Solution();
		for (int i = 0; i < tests.length; i++) {
			List<TreeNode> rootsTreeNode = solution.generateTrees(tests[i]);
			for (int j = 0; j < rootsTreeNode.size(); j++) {
				List<Integer> stringList = new ArrayList<>();
				solution.preorder(stringList, rootsTreeNode.get(j));
				System.out.println(stringList);
			}
		}
		
	}
	private void preorder(List<Integer> result,TreeNode root) {
		if(root == null)
			return;
		result.add(root.val);
		preorder(result,root.left);
		preorder(result, root.right);
	}
}
