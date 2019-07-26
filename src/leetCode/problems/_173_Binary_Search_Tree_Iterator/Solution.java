package leetCode.problems._173_Binary_Search_Tree_Iterator;

import java.util.LinkedList;

import leetCode.problems.commonUtil.TreeNode;

class BSTIterator {
	private LinkedList<TreeNode> base = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        while (root!=null) {
			base.add(root);
			root = root.left;
		}
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode a = base.pollLast();
        int result = a.val;
        a=a.right;
        while (a!=null) {
			base.add(a);
			a=a.left;
		}
        return result;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !base.isEmpty();
    }
}
