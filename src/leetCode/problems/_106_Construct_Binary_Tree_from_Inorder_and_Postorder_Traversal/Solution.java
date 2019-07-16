package leetCode.problems._106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.LinkedList;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	TreeNode root = null;
		if(postorder.length==0||postorder.length!=inorder.length)
			return root;
		LinkedList<TreeNode> baseLinkedList = new LinkedList<>();
		int i=postorder.length-1,j=i;
		root = new TreeNode(postorder[i]);
		baseLinkedList.add(root);
		while (true) {
			if(i==-1) 
				return root;
			if(postorder[i]==inorder[j]) {
				j--;
				if((j<inorder.length&&baseLinkedList.size()>1&&
						inorder[j]==baseLinkedList.get(baseLinkedList.size()-2).val)) {
					while (j<inorder.length&&baseLinkedList.size()>1&&
							inorder[j]==baseLinkedList.get(baseLinkedList.size()-2).val) {
						baseLinkedList.removeLast();
						j--;
					}
				}
				if(--i==-1)
					return root;
				TreeNode newRoot01 = new TreeNode(postorder[i]);
				baseLinkedList.getLast().left=newRoot01;
				baseLinkedList.removeLast();
				baseLinkedList.add(newRoot01);
			}else {
				while (i<postorder.length&&postorder[i]!=inorder[j]) {
					if(baseLinkedList.getLast().val!=postorder[i]) {
						TreeNode newRoot = new TreeNode(postorder[i]);
						baseLinkedList.getLast().right=newRoot;
						baseLinkedList.add(newRoot);
					}
					i--;
				}
				if(i==-1) 
					return root;
				else {
					TreeNode newRoot02 = new TreeNode(postorder[i]);
					baseLinkedList.getLast().right=newRoot02;
					baseLinkedList.add(newRoot02);
				}
			}
		}
    }
	public static void main(String[] args) throws InterruptedException {
		int[][][] testdata = {
				{{9,3,15,20,7},{9,15,7,20,3}},
		};
		Solution solution = new Solution();

		for (int i = 0; i < testdata.length; i++) {
			TreeNode test = solution.buildTree(testdata[i][0], testdata[i][1]);
			System.out.println(test);
		}
	}
}
