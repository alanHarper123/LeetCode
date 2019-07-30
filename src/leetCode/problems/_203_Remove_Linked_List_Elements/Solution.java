package leetCode.problems._203_Remove_Linked_List_Elements;

import leetCode.problems.commonUtil.ListNode;

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = null;
        ListNode newHead = head;
        while (head!=null) {
        	if(head.val == val) {
        		if(pre!=null) {
        			pre.next = head.next;
        		}
        		if(newHead==head)
        			newHead = head.next;	
        	}else {
        		pre = head;
        	}
        	head = head.next;	
		}
        return newHead;
        
    }
}
