package leetCode.problems._108_Convert_Sorted_Array_to_Binary_Search_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0,nums.length/2,nums.length);
    }
    public TreeNode sortedArrayToBST(int[] nums,int start,int mid,int end) {
        if(start==end)
        	return null;
        TreeNode root = new TreeNode(nums[mid]);
        if(start+1==end)
        	return root;
        root.left = sortedArrayToBST(nums,start,(start+mid)/2,mid);
        root.right = sortedArrayToBST(nums,mid+1,(mid+1+end)/2,end);
        return root;
    }
	public static void main(String[] args) throws InterruptedException {
		int[][] testdata = 
				{
						{-10,-3,0,5,9},
				}
		;
		Solution solution = new Solution();

		for (int i = 0; i < testdata.length; i++) {
			TreeNode test = solution.sortedArrayToBST(testdata[i]);
			System.out.println(test);
		}
	}
}
