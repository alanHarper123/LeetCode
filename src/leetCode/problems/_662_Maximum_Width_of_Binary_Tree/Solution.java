package leetCode.problems._662_Maximum_Width_of_Binary_Tree;

import java.util.ArrayList;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        ArrayList<Integer> leftBs = new ArrayList<>();
        ArrayList<Integer> rightBs = new ArrayList<>();
        findWith(root, leftBs, rightBs, 0, 0);
        for (int i = 0; i < leftBs.size(); i++) {
			int width = rightBs.get(i)-leftBs.get(i)+1;
			if(width>maxWidth)
				maxWidth = width;
		}
        return maxWidth;
    }
    private void findWith(TreeNode root,ArrayList<Integer>leftBs,ArrayList<Integer>rightBs,int level,int dis) {
    	if(root==null)
    		return;
    	if(level==leftBs.size()) {
    		leftBs.add(dis);
    		rightBs.add(dis);
    	}else {
    		if(dis<leftBs.get(level)) {
    			leftBs.set(level, dis);
    		}else if(dis>rightBs.get(level)) {
    			rightBs.set(level, dis);
    		}
    	}
    	findWith(root.left, leftBs, rightBs, level+1, 2*dis+1);
    	findWith(root.right, leftBs, rightBs, level+1, 2*dis+2);
    	
    }
}
