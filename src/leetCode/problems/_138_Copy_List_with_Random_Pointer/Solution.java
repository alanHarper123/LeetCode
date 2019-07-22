package leetCode.problems._138_Copy_List_with_Random_Pointer;

import java.util.HashMap;

//Definition for a Node.
class Node {
	public int val;
	public Node next;
	public Node random;

	public Node() {}

	public Node(int _val,Node _next,Node _random) {
		val = _val;
		next = _next;
		random = _random;
	}
};

public class Solution {
	public Node copyRandomList(Node head) {
		Node runner = head;
		Node newHead = null;
		Node preRunner = null;
		HashMap<Node, Node> nodeMap = new HashMap<>();
		while (runner!=null) {
			Node newNode = new Node(runner.val,null,null);
			nodeMap.put(runner, newNode);
			if(preRunner!=null) {
				preRunner.next=newNode;
			}else {
				newHead=newNode;
			}
			preRunner = newNode;
			runner = runner.next;
		}
		runner = head;
		Node newRunner = newHead;
		while (runner!=null) {
			newRunner.random = nodeMap.get(runner.random);
			runner = runner.next;
			newRunner = newRunner.next;
		}
		return newHead;
	}
}
