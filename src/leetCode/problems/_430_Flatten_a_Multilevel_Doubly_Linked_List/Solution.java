package leetCode.problems._430_Flatten_a_Multilevel_Doubly_Linked_List;


//Definition for a Node.
class Node {
	public int val;
	public Node prev;
	public Node next;
	public Node child;
};


class Solution {
	public Node flatten(Node head) {
		if(head==null)
			return head;
		flattenEnd(head);
		return head;
	}
	private Node flattenEnd(Node head) {
		Node runner = head;
		Node pre = runner;
		while (runner!=null) {
			if(runner.child!=null) {
				runner.child.prev = runner;
				Node childEnd = flattenEnd(runner.child);
				childEnd.next = runner.next;
				runner.next = runner.child;
				runner.child=null;
				pre = childEnd;
				runner = childEnd.next;
				if(runner!=null)
					runner.prev=childEnd;
			}else {
				pre = runner;
				runner = runner.next;
			}
					
		}
		return pre;
	}
}
