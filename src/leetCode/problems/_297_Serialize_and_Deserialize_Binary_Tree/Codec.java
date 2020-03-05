package leetCode.problems._297_Serialize_and_Deserialize_Binary_Tree;

import java.util.LinkedList;
import java.util.Queue;

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
    	if(root==null)
    		return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> tq = new LinkedList<>();
        tq.add(root);
        while (!tq.isEmpty()) {
			TreeNode k = tq.poll();
			if(k==null) {
				sb.append(k);
			}else {
				sb.append(k.val);
			}
			
			sb.append(',');
			if(k!=null) {
				tq.add(k.left);
				tq.add(k.right);
			}
		}
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null)
        	return null;
        String[] base = data.split(",");
        TreeNode result  = new TreeNode(Integer.valueOf(base[0]));
        Queue<TreeNode> tq = new LinkedList<>();
        tq.add(result);
        for (int i = 1; i < base.length; i++) {
			TreeNode k = tq.poll();
			if(!base[i].equals("null")) {
				TreeNode nt = new TreeNode(Integer.valueOf(base[i]));
				k.left = nt;
				tq.add(nt);
			}				
			i++;
			if(!base[i].equals("null")) {
				TreeNode nt = new TreeNode(Integer.valueOf(base[i]));
				k.right = nt;
				tq.add(nt);
			}
		}
        return result;
    }
    public static void main(String[] args) {
		Codec codec = new Codec();
		System.out.println(codec.deserialize("1,2,3,null,null,4,5"));
	}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
