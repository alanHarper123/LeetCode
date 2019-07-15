package leetCode.problems._99_Recover_Binary_Search_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.sun.net.httpserver.Authenticator.Result;

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	TreeNode[] result = {null,null};
	public void recoverTree(TreeNode root) {

		Arrays.fill(result, null);
		
//		morris_Traversal(root);
		
		inorder_travel(root, null);
		if(result[0]==null||result[1]==null)
			System.out.println("mistake happens");
		else {
			int tmp = result[0].val;
			result[0].val = result[1].val;
			result[1].val = tmp;	
		}
	}
//try01 morris_Traversal runtime O(n+2*lgn), memory O(1);
	private void morris_Traversal(TreeNode root) {
		TreeNode preElement = null;
		TreeNode connector = null;
		while (root!=null) {
			if(root.left==null) {
//				System.out.println(root.val);
				if(preElement!=null&&root.val<preElement.val) {
					
					if(result[0]==null)
						result[0]=preElement;
					result[1]=root;	
				}
				preElement = root;	
				root = root.right;
			}else {
				connector = root.left;
				while (connector.right!=null&&connector.right.val!=root.val) 
					connector = connector.right;
				if(connector.right==null) {
					connector.right = root;
					root = root.left;
				}else {
					connector.right = null;
//					System.out.println(root.val);
					if(root.val<preElement.val) {
						if(result[0]==null)
							result[0]=preElement;
						result[1]=root;
					}
					preElement = root;
					root = root.right;
				}	
			}
		}
	}
	//try02 ordinary Inorder travel, runtime O(n), memory O(lgn);

	private TreeNode inorder_travel(TreeNode root,TreeNode preNode) {
		if(root == null)
			return preNode;
		preNode = inorder_travel(root.left,preNode);
		if(preNode!=null&&preNode.val>root.val) {
			if(result[0]==null)
				result[0]=preNode;
			result[1]=root;
		}
//		System.out.println(root.val);
		return inorder_travel(root.right,root);	
	}
	public static void main(String[] args) throws InterruptedException {
		Integer[][] testdata = {
				{3,1,4,null,null,2},
				{0,1},
				{2,3,1},
				{1,3,null,null,2},	
				{3,1,4,null,null,2},
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
			solution.recoverTree(listNode);
			List<Integer> stringIntegers = new ArrayList<>();
			solution.preorder(stringIntegers, listNode, 0);	
			System.out.println(stringIntegers);
			System.out.println("----------");
			solution.recoverTree(listNode);
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
