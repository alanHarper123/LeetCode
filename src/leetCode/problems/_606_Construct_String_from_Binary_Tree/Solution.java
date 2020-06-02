package leetCode.problems._606_Construct_String_from_Binary_Tree;

import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private static String emtyString = "";
	public String tree2str(TreeNode t) {
		if(t==null)
			return emtyString;
		String left = tree2str(t.left);
		String right = tree2str(t.right);
		String rootS = String.valueOf(t.val);
		if(left==emtyString&&right==emtyString) {
			return rootS;
		}
		if(left!=emtyString&&right==emtyString) {
			return rootS+"("+left+")";
		}
		return rootS+"("+left+")"+"("+right+")";
	}
}
