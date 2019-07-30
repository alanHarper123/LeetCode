package leetCode.problems._206_Reverse_Linked_List;

import leetCode.problems.commonUtil.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode temp;
        while (head!=null) {
        	temp = head.next;
        	head.next = newHead;
        	newHead = head;
        	head = temp;
		}
        return newHead;
    }
}
