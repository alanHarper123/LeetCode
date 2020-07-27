package leetCode.problems._872_Leaf_Similar_Trees;

import java.util.Iterator;
import java.util.LinkedList;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	if(root1==root2)
    		return true;
    	LinkedList<Integer> ls1 = new LinkedList<>();
    	getLeafSequence(root1, ls1);
    	LinkedList<Integer> ls2 = new LinkedList<>();
    	getLeafSequence(root2, ls2);
    	Iterator<Integer> iter1 = ls1.iterator();
    	Iterator<Integer> iter2 = ls2.iterator();
    	while (iter1.hasNext()&&iter2.hasNext()) {
    		if(iter1.next()!=iter2.next())
    			return false;
		}
    	if(iter1.hasNext()||iter2.hasNext())
    		return false;
    	return true;
    }
    private void getLeafSequence(TreeNode root,LinkedList<Integer> ls){
    	if(root.left==null&&root.right==null) {
    		ls.add(root.val);
    		return;
    	}
    	if(root.left!=null)
    		getLeafSequence(root.left, ls);
    	if(root.right!=null)
    		getLeafSequence(root.right, ls);
    }
}
