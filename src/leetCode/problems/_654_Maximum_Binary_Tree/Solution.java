package leetCode.problems._654_Maximum_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums==null)
        	return null;
        return constructMaximumBinaryTreeUtil(nums, 0, nums.length);
    }
    private TreeNode constructMaximumBinaryTreeUtil(int[] nums,int start,int end) {
        if(start==end)
        	return null;
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = start; i < end; i++) {
			if(max<nums[i]) {
				max = nums[i];
				maxIndex = i;
			}
		}
        TreeNode node = new TreeNode(max);
        node.left = constructMaximumBinaryTreeUtil(nums, start, maxIndex);
        node.right = constructMaximumBinaryTreeUtil(nums, maxIndex+1,end);
        return node;
    }
}
