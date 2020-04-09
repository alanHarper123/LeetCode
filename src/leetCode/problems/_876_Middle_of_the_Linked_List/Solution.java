package leetCode.problems._876_Middle_of_the_Linked_List;

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
    public ListNode middleNode(ListNode head) {
    	// head is not null
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        while (fastRunner!=null&&fastRunner.next!=null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
        return slowRunner;
    }
}
