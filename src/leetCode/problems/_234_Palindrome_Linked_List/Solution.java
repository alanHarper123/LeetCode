package leetCode.problems._234_Palindrome_Linked_List;

import leetCode.problems.commonUtil.ListNode;

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slowRunner = head;
        ListNode fastRunner = head;
        ListNode reverseT = null;
        ListNode temp = null;
        while (fastRunner!=null && fastRunner.next!=null) {
        	fastRunner = fastRunner.next.next;
        	temp = slowRunner.next;
        	slowRunner.next = reverseT;
        	reverseT = slowRunner;
        	slowRunner = temp;
		}
        if(fastRunner!=null) {
        	slowRunner = slowRunner.next;
        }
        while(slowRunner!=null&&reverseT!=null) {
        	if(reverseT.val!=slowRunner.val)
        		return false;
        	reverseT = reverseT.next;
        	slowRunner = slowRunner.next;
        }
        return true;	
    }
}
