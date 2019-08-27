package leetCode.problems._222_Count_Complete_Tree_Nodes;


import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public int countNodes(TreeNode root) {
    	int rightH = countRightH(root);
    	
    	if(rightH==0)
    		return 0;
    	return track(rightH, 0, root);
    	
    }
    private int track(int rightH, int CurrentC, TreeNode root) {
    	if(rightH==1)
    		return countResult(CurrentC, root);
    	else {
    		if(countRightH(root.left)==--rightH)
    			return track(rightH, 2*CurrentC+1, root.left);
    		else {
    			return track(rightH, 2*CurrentC+2, root.right);
    		}
    	}
    }
    private int countRightH(TreeNode root) {
    	int h = 0;
    	while (root!=null) {
			h++;
			root = root.right;
		}
    	return h;
    }
    private int countResult(int CurrentC, TreeNode root) {
    	if(root.left==null) {
			return 2*CurrentC+1;
    	}else 
    		return 2*CurrentC+2;
    }
}
