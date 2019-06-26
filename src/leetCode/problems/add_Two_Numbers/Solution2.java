package leetCode.problems.add_Two_Numbers;



public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultOrigin = result;
        int carry = 0;
        while(l1!=null||l2!=null) {

        	if(l1!=null) {
        		carry += l1.val;
        		l1 = l1.next;
        	}
        	if(l2!=null) {
        		carry += l2.val;
        		l2 = l2.next;
        	}
        	
        	result.next = new ListNode(carry%10);
        	carry/=10;
        	result = result.next;    	
        }
        if(carry!=0) {
        	result.next = new ListNode(1);
        }
        
        return resultOrigin.next;
    }
}
