package leetCode.problems._449_Serialize_and_Deserialize_BST;

import java.util.LinkedList;
import leetCode.problems.commonUtil.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder stringBuilder = new StringBuilder();
		if(root==null)
			return "";
		serializeUtil(root, stringBuilder);
		return stringBuilder.deleteCharAt(stringBuilder.length()-1).toString();
	}
	private void serializeUtil(TreeNode root, StringBuilder stringBuilder) {
		stringBuilder.append(root.val);
		stringBuilder.append(' ');
		if(root.left!=null)
			serializeUtil(root.left, stringBuilder);
		if(root.right!=null)
			serializeUtil(root.right,stringBuilder);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if(data.equals(""))
			return null;
		String[] values = data.split(" ");
		TreeNode head = null;
		int i = 0;
		LinkedList<TreeNode> leftBones = new LinkedList<>();

		head = new TreeNode(Integer.valueOf(values[i]));
		leftBones.add(head);

		TreeNode pre = head;
		for (int j = 1; j < values.length; j++) {
			Integer val = Integer.valueOf(values[j]);
			TreeNode leftBone = new TreeNode(val);
			if(pre.val>val) {
				pre.left = leftBone;
			}else {
				leftBones.pollLast();
				TreeNode parentLeftBone = leftBones.peekLast();
				while (parentLeftBone!=null&&parentLeftBone.val<val) {
					pre = parentLeftBone;
					leftBones.pollLast();
					parentLeftBone = leftBones.peekLast();
				}
				pre.right = leftBone;
			}
			pre = leftBone;
			leftBones.add(leftBone);
		}
		return head;
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
