package leetCode.problems._1026_Maximum_Difference_Between_Node_and_Ancestor;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	int maxDif = 0;
    public int maxAncestorDiff(TreeNode root) {
        maxDif = 0;
        minAndMaxUtil(root);
        return maxDif;
    }
    private int[] minAndMaxUtil(TreeNode root) {
    	int[] rootM = null;
    	if(root.left!=null) {
    		rootM = minAndMaxUtil(root.left);	
    	}
    	if(root.right!=null) {
    		int[] rightB = minAndMaxUtil(root.right); 
    		if(rootM==null) 
    			rootM = rightB;
    		else {
    			rootM[0] = Math.min(rootM[0], rightB[0]);
    			rootM[1] = Math.max(rootM[1], rightB[1]);
    		}
    	}
    	if(rootM==null) {
    		rootM = new int[] {root.val,root.val};
    	}else {
    		maxDif = Math.max(maxDif, Math.abs(rootM[1]-root.val));
    		maxDif = Math.max(maxDif, Math.abs(rootM[0]-root.val));
    		if(root.val>rootM[1]) 
    			rootM[1] = root.val;
    		else if (root.val<rootM[0]) 
    			rootM[0] = root.val;
    	}
    	return rootM;
    }
}
