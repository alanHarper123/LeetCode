package leetCode.problems._Cousins_in_Binary_Tree;

import java.util.LinkedList;


import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null||x==y)
        	return false;
        LinkedList<TreeNode> bfsFronts = new LinkedList<>();
        bfsFronts.add(root);
        bfsFronts.add(null);
        boolean metX=false;
        TreeNode xPNode = null;
		boolean metY=false;
		TreeNode yPNode = null;
        while (!bfsFronts.isEmpty()) {
			int bfsFrontsC = bfsFronts.size();			
			while (bfsFrontsC>0) {
				bfsFrontsC-=2;
				TreeNode bfsFront = bfsFronts.pollFirst();
				TreeNode parent = bfsFronts.pollFirst();
				if(bfsFront.val==x) {
					metX=true;
					xPNode = parent;
					if(metY&&xPNode!=null&&yPNode!=null&&yPNode.val!=xPNode.val)
						return true;
				}else if(bfsFront.val==y) {
					metY=true;
					yPNode = parent;
					if(metX&&xPNode!=null&&yPNode!=null&&yPNode.val!=xPNode.val)
						return true;
				}
				if(bfsFront.left!=null) {
					bfsFronts.add(bfsFront.left);
					bfsFronts.add(bfsFront);
				}
					
				if(bfsFront.right!=null) {
					bfsFronts.add(bfsFront.right);
					bfsFronts.add(bfsFront);
				}
					
			}
			if(metX||metY)
				return false;
		}
        return true;
    }
}
