package leetCode.problems._328_Odd_Even_Linked_List;

import leetCode.problems.commonUtil.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode runner = head;
        ListNode oddRunner = null;
        ListNode oddHead = null;
        ListNode evenRunner = null;
        boolean isEven = true;
        while (runner!=null) {
			if(isEven) {
				if(evenRunner==null)
					evenRunner = runner;
				else {
					evenRunner.next = runner;
					evenRunner = runner;
				}	
			}else {
				if(oddRunner==null) {
					oddHead = runner;
					oddRunner = runner;
				}
				else {
					oddRunner.next = runner;
					oddRunner = runner;
				}
			}
			isEven = !isEven;
			runner = runner.next;
		}
        if(oddRunner!=null)
        	oddRunner.next = null;
        if(evenRunner!=null)
        	evenRunner.next = oddHead;
        return head;
    }
}
