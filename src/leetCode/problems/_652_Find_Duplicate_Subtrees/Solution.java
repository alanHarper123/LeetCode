package leetCode.problems._652_Find_Duplicate_Subtrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import leetCode.problems.commonUtil.TreeNode;
class Node{
	TreeNode val;
	boolean isLeftChild;
	Node parent;
	public Node(TreeNode val,boolean isLeftChild,Node parent) {
		this.isLeftChild = isLeftChild;
		this.parent = parent;
		this.val = val;
	}
}
public class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    	
    	List<TreeNode> duplicates = new LinkedList<>();
    	if(root!=null) {
    		ArrayList<Node> leafs = new ArrayList<Node>();
            buildNodes(null, true, root, leafs);
            getDuplicates(duplicates, leafs,true);
    	}
        return duplicates;
    }
    private void buildNodes(Node parent,Boolean isLeftChild, TreeNode root,ArrayList<Node> leafs) {
    	Node newNode = new Node(root, isLeftChild, parent);
    	if(root.left==null&&root.right==null) {
    		leafs.add(newNode);
    	}else {
    		if(root.left!=null)
    			buildNodes(newNode, true, root.left, leafs);
    		if(root.right!=null) 
    			buildNodes(newNode, false, root.right, leafs);
    	}
    }
    private void getDuplicates(List<TreeNode> duplicates,ArrayList<Node> leafs,boolean isLeftC) {
    	ArrayList<ArrayList<Node>> leftPs = new ArrayList<>();
    	ArrayList<TreeNode> vals = new ArrayList<>();
    	ArrayList<ArrayList<Node>> rightPs = new ArrayList<>();
    	loop1:for (int i = 0; i < leafs.size(); i++) {
			Node leaf = leafs.get(i);
			ArrayList<ArrayList<Node>> pNodes = rightPs;
			ArrayList<ArrayList<Node>> OtherPNodes = leftPs;
			if(leaf.isLeftChild) {
				pNodes = leftPs;
				OtherPNodes = rightPs;
			}
			for (int j = 0; j < vals.size(); j++) {
				
				if(leaf.val.val == vals.get(j).val) {
					if(isLeftC) {
						if(leaf.val.right==null&&vals.get(j).right==null) {
							pNodes.get(j).add(leaf.parent);
							continue loop1;
						}
					}else {
						if(isTreeEqual(leaf.val.left, vals.get(j).left)) {
							pNodes.get(j).add(leaf.parent);
							continue loop1;
						}
					}
				}
			}
			ArrayList<Node> newParents = new ArrayList<>();
			newParents.add(leaf.parent);
			pNodes.add(newParents);
			OtherPNodes.add(new ArrayList<>());
			vals.add(leaf.val);
		}
    	for (int j = 0; j < vals.size(); j++) {
    		ArrayList<Node> leftP = leftPs.get(j);
    		ArrayList<Node> rightP = rightPs.get(j);
    		if(leftP.size()+rightP.size()>=2)
    			duplicates.add(vals.get(j));
    		if(leftP.size()>=2) {
    			getDuplicates(duplicates, leftP,true);
    		}
    		if(rightP.size()>=2) {
    			getDuplicates(duplicates, rightP,false);
    		}
		}
    }
    private boolean isTreeEqual(TreeNode root1,TreeNode root2) {
    	if(root1==null&&root2==null)
    		return true;
    	if(root1==null||root2==null)
    		return false;
    	if(root1.val!=root2.val)
    		return false;
    	return isTreeEqual(root1.left, root2.left)&&isTreeEqual(root1.right, root2.right);
    }
}
