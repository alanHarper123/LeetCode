package leetCode.problems.add_Two_Numbers;


 //Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultOrigin = result;
        Boolean ten = false;
        while (l1 != null) {
        	if(l2!=null) {
        		int a = l1.val+l2.val+ (ten?1:0);		
        		if(a<10) {
        			result.val = a;
        			ten = false;
        		}else {
        			result.val = a-10;
        			ten = true;

        		}
        		if(l1.next!=null||l2.next!=null) {
        			result.next = new ListNode(0);
        			result=result.next;
        		}else {
        			if(ten) {
        				result.next = new ListNode(1);
        			}
					ten = false;
					l1=l1.next;
					l2=l2.next;
					break;
				}
        		l1=l1.next;
				l2=l2.next;
        	}else {
        		int b = l1.val + (ten?1:0);
        		if(b<10) {
        			result.val = b;
        			ten = false;
        		}else {
        			result.val = b-10;
        			ten = true;
        		}
        		result.next = l1.next;
        		
        		break;
        	}	
		}
        
        if(l2!=null) {
        	int c = l2.val + (ten?1:0);
        	if(c<10) {
        		result.val = c;
        		ten = false;
        	}else {
        		result.val = c-10;
        		ten = true;
        	}
        	result.next = l2.next;
        }
        
        while(ten) {
        	if(result.next!=null) {
        		
        		int d = result.next.val+1;
        		if(d<10) {
        			 result.next.val = d;
        			 ten = false;
        		}else{
        			result.next.val = d-10;
        			ten=true;
        			result = result.next;
        		}
        		
        	}else{
        		result.next = new ListNode(1);
        		ten=false;
        	}
			
		}
        
        return resultOrigin;
    }
}
