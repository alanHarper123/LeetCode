package leetCode.problems._98_Validate_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public boolean isValidBST(TreeNode root) {
		long minBound = (long)Integer.MIN_VALUE-1;
		long maxBound = (long)Integer.MAX_VALUE+1;

		return isValidBST(root, minBound, maxBound);
			
	}
	private boolean isValidBST(TreeNode root,long minBound,long maxBound) {
		if(root==null)
			return true;
		if(root.val<=minBound||root.val>=maxBound)
			return false;
		if (!isValidBST(root.left,minBound, root.val)) 
			return false;
		if(!isValidBST(root.right,root.val, maxBound))
			return false;
		return true;
	}
	public static void main(String[] args) throws InterruptedException {
		Integer[][] testdata = {
				{2,1,3},	
				{5,1,4,null,null,3,6},
		};
		Solution solution = new Solution();
		ArrayList<TreeNode> testsArrayList = new ArrayList<>();
		for (int i = 0; i < testdata.length; i++) {
			TreeNode test = solution.buildTreeNode(testdata[i], 0);
			List<Integer> stringIntegers = new ArrayList<>();
			solution.preorder(stringIntegers, test, 0);
			System.out.println(stringIntegers);
			testsArrayList.add(test);
		}

		for (Iterator<TreeNode> iterator = testsArrayList.iterator(); iterator.hasNext();) {
			TreeNode listNode =  iterator.next();
			System.out.println(solution.isValidBST(listNode));
			System.out.println("----------");
		}
	}
	private TreeNode buildTreeNode(Integer[] base,int start) {
		
		TreeNode newRoot=null;
		if(base[start]!=null) 
			newRoot = new TreeNode(base[start]);
		else 
			return null;	
		if(2*start+1<base.length)
			newRoot.left = buildTreeNode(base,2*start+1);
		if(2*start+2<base.length)
			newRoot.right = buildTreeNode(base,2*start+2);
		return newRoot;
	}
	private void preorder(List<Integer> result,TreeNode root,int start) {
		if(root == null) 
			return;
		while (result.size()<=start) {
			result.add(null);
		}
		result.set(start, root.val);
		preorder(result, root.right,2*start+2);
		preorder(result,root.left,2*start+1);
		
	}
}
