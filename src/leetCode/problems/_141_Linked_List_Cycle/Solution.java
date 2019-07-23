package leetCode.problems._141_Linked_List_Cycle;


import leetCode.problems.commonUtil.ListNode;

public class Solution {
	public boolean hasCycle(ListNode head) {
		ListNode indicator = new ListNode(0);
		ListNode temp;
		while (head!=null) {
			if(head==indicator) {
				return true;
			}else {
				temp=head.next;
				head.next = indicator;
				head = temp;
			}
		}
		return false;
	}
}
