package leetCode.problems._116_Populating_Next_Right_Pointers_in_Each_Node;


import leetCode.problems.commonUtil.Node;
class Solution {
	public Node connect(Node root) {
		
		Node preLevelRunner = root;
		Node currentLevelRunner = null;
		Node currentLevelKeeper = null;
		
		while(preLevelRunner!=null) {
			while(preLevelRunner!=null) {
				if(currentLevelRunner==null) {
					currentLevelKeeper=preLevelRunner.left;
					currentLevelRunner=currentLevelKeeper;
					if(currentLevelRunner==null)
						break;
				}	
				else {
					currentLevelRunner.next=preLevelRunner.left;
					currentLevelRunner=preLevelRunner.left;
				}	
				currentLevelRunner.next=preLevelRunner.right;
				currentLevelRunner=preLevelRunner.right;
				preLevelRunner = preLevelRunner.next;
			}
			preLevelRunner=currentLevelKeeper;
			if(currentLevelRunner!=null) {
				currentLevelRunner.next=null;
				currentLevelRunner=null;
			}
		}
		return root;
	}

}
