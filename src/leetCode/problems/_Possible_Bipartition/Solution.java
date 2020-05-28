package leetCode.problems._Possible_Bipartition;

import java.util.LinkedList;

class Node{
	int index;
	boolean isLeftSide;
	LinkedList<Node> dislikeNs = new LinkedList<>();
	public Node(int _index) {
		this.index = _index;
	}
}
public class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Node[] allNodes = new Node[N+1];
        boolean[] wasVisited = new boolean[N+1];
        for (int[] dislike:dislikes) {
			if(allNodes[dislike[0]]==null)
				allNodes[dislike[0]] = new Node(dislike[0]);
			if(allNodes[dislike[1]]==null)
				allNodes[dislike[1]] = new Node(dislike[1]);
			allNodes[dislike[0]].dislikeNs.add(allNodes[dislike[1]]);
			allNodes[dislike[1]].dislikeNs.add(allNodes[dislike[0]]);
		}
        for (int i = 1; i < allNodes.length; i++) {
			Node node = allNodes[i];
			if(node!=null&&wasVisited[i]==false) {
				if(bipartition(node, wasVisited, true)==false)
					return false;
			}
		}
        return true;
    }
    private boolean bipartition(Node node, boolean[] wasVisited, boolean isLeftSide) {
    	wasVisited[node.index] = true;
    	node.isLeftSide = isLeftSide;
    	for (Node dislikeN:node.dislikeNs) {
    		if(wasVisited[dislikeN.index]) {
    			if(dislikeN.isLeftSide==node.isLeftSide)
    				return false;
    		}else {
    			if(bipartition(dislikeN, wasVisited, !isLeftSide)==false)
    				return false;
    		}
		}
    	return true;
    }
}
