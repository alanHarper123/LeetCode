package leetCode.problems._First_Unique_Number;


import java.util.HashMap;
import java.util.HashSet;

class Node{
	int val;
	Node next;
	Node pre;
	public Node(int val,Node pre) {
		this.val = val;
		this.pre = pre;
	}
}
public class FirstUnique {
	private HashMap<Integer, Node> uniqueNodes;
	private HashSet<Integer> uIntegers;
	private Node head;
	private Node tail;
	public FirstUnique(int[] nums) {
		uniqueNodes = new HashMap<>();
		uIntegers = new HashSet<>();
		head = null;
		tail = null;
		
		for (int i = 0; i < nums.length; i++) {
			add(nums[i]);
		}

	}

	public int showFirstUnique() {
		if(head!=null)
			return head.val;
		return -1;
	}
	public void add(int value) {
		if(uIntegers.add(value)) {
			addNode(value);
		}else 
			if(uniqueNodes.containsKey(value)) 
				deleteNode(uniqueNodes.get(value));
	}
	private void addNode(int val) {
		Node nodei = new Node(val, tail);
		uniqueNodes.put(val, nodei);
		if(tail!=null) {
			tail.next=nodei;
		}else 
			head = nodei;
		tail = nodei;
	}
	private void deleteNode(Node node) {
		if(head==node)
			head = head.next;
		if(tail==node)
			tail = tail.pre;
		if(node.pre!=null)
			node.pre.next = node.next;
		if(node.next!=null)
			node.next.pre = node.pre;
		uniqueNodes.remove(node.val);
	}
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
