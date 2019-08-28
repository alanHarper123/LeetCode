package leetCode.problems._230_Kth_Smallest_Element_in_a_BST;

import leetCode.problems.commonUtil.TreeNode;

class Solution {
	private int index = 0;
	private Integer result = null;
    public int kthSmallest(TreeNode root, int k) {
       index = 0;
       result = null;
       findK(root, k);
       return result;
    }
    private void findK(TreeNode root, int k) {
    	 if(root==null||result!=null)
         	return;
    	 findK( root.left, k);
         if(++index==k) {
        	 result = root.val;
        	 return;
         }
         findK( root.right, k);
    }
}
