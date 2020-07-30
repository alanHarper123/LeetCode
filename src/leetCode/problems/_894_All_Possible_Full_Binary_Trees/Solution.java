package leetCode.problems._894_All_Possible_Full_Binary_Trees;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public List<TreeNode> allPossibleFBT(int N) {
    	if(N%2==0)
    		return new LinkedList<>();
    	List<TreeNode>[] base = new List[(N+1)/2];
    	for (int i = 0; i < base.length; i++) {
    		base[i] = new LinkedList<TreeNode>();
		}
    	base[0].add(new TreeNode(0));
    	for (int i = 1; i < base.length; i++) {
			for (int j = 0; j < i; j++) {
				Iterator<TreeNode> iterL = base[j].iterator();
				while (iterL.hasNext()) {
					TreeNode left = iterL.next();
					Iterator<TreeNode> iterR = base[i-1-j].listIterator(0);
					while (iterR.hasNext()) {
						TreeNode right = iterR.next();
						TreeNode root = new TreeNode(0);
						root.left = left;
						root.right = right;
						base[i].add(root);
					}
				}
			}
		}
    	return base[base.length-1];
    }
}
