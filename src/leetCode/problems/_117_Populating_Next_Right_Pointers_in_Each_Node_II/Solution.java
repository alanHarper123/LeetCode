package leetCode.problems._117_Populating_Next_Right_Pointers_in_Each_Node_II;

import leetCode.problems.commonUtil.Node;

class Solution {
	public Node connect(Node root) {
		Node preLevelRunner = root;
		Node currentLevelRunner = null;
		Node currentLevelKeeper = null;

		while(preLevelRunner!=null) {
			while(preLevelRunner!=null) {
				if (preLevelRunner.left!=null) {
					if(currentLevelRunner==null) {
						currentLevelKeeper=preLevelRunner.left;
						currentLevelRunner=currentLevelKeeper;
					}else {
						currentLevelRunner.next = preLevelRunner.left;
						currentLevelRunner=currentLevelRunner.next;
					}
					if(preLevelRunner.right!=null) {
						currentLevelRunner.next = preLevelRunner.right;
						currentLevelRunner = currentLevelRunner.next;
					}
				}else if (preLevelRunner.right!=null){
					if(currentLevelRunner==null) {
						currentLevelKeeper=preLevelRunner.right;
						currentLevelRunner=currentLevelKeeper;
					}else {
						currentLevelRunner.next = preLevelRunner.right;
						currentLevelRunner = currentLevelRunner.next;
					}
				}
				preLevelRunner = preLevelRunner.next;
			}
			preLevelRunner=currentLevelKeeper;
			if(currentLevelRunner!=null)
				currentLevelRunner=null;
			else 
				break;
		}
		return root;
	}
	public static void main(String[] args) {
		Integer[][] testdata = {
				{1,2,3,4,5,null,7},
		};
		Solution solution = new Solution();

		for (int i = 0; i < testdata.length; i++) {
			Node test = solution.connect(Node.buildTreeNode(testdata[i], 0));
			System.out.println(test);
		}
	}
}
