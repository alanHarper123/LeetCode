package leetCode.problems._105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal;

import java.util.LinkedList;
import leetCode.problems.commonUtil.TreeNode;

class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode root = null;
		if(preorder.length==0||preorder.length!=inorder.length)
			return root;
		LinkedList<TreeNode> baseLinkedList = new LinkedList<>();
		root = new TreeNode(preorder[0]);
		baseLinkedList.add(root);
		int i=0,j=0;
		while (true) {
			if(i==preorder.length) 
				return root;
			if(preorder[i]==inorder[j]) {
				j++;
				if((j<inorder.length&&baseLinkedList.size()>1&&
						inorder[j]==baseLinkedList.get(baseLinkedList.size()-2).val)) {
					while (j<inorder.length&&baseLinkedList.size()>1&&
							inorder[j]==baseLinkedList.get(baseLinkedList.size()-2).val) {
						baseLinkedList.removeLast();
						j++;
					}
				}
				if(++i==preorder.length)
					return root;
				TreeNode newRoot01 = new TreeNode(preorder[i]);
				baseLinkedList.getLast().right=newRoot01;
				baseLinkedList.removeLast();
				baseLinkedList.add(newRoot01);
			}else {
				while (i<preorder.length&&preorder[i]!=inorder[j]) {
					if(baseLinkedList.getLast().val!=preorder[i]) {
						TreeNode newRoot = new TreeNode(preorder[i]);
						baseLinkedList.getLast().left=newRoot;
						baseLinkedList.add(newRoot);
					}
					i++;
				}
				if(i==preorder.length) 
					return root;
				else {
					TreeNode newRoot02 = new TreeNode(preorder[i]);
					baseLinkedList.getLast().left=newRoot02;
					baseLinkedList.add(newRoot02);
				}
			}
		}	
	}
	public static void main(String[] args) throws InterruptedException {
		int[][][] testdata = {
				{{3,1,2,4},{1,2,3,4}},
				{{1,2,3},{1,3,2}},
				{{1,2},{2,1}},
				{{1,2,3},{2,3,1}},
				{{3,9,20,15,7},{9,3,15,20,7}},
				{{1,2,3},{1,2,3}},

				{{1,2},{1,2}},


		};
		Solution solution = new Solution();

		for (int i = 0; i < testdata.length; i++) {
			TreeNode test = solution.buildTree(testdata[i][0], testdata[i][1]);
			System.out.println(test);
		}

	}
}
