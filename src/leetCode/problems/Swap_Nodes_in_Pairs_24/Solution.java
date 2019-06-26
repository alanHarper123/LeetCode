package leetCode.problems.Swap_Nodes_in_Pairs_24;


// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
    	ListNode result;
    	if(head==null||head.next==null) {
    		return head;
    	}else {
			result = head.next;
		}
    	ListNode pair1 = head;
    	ListNode pair2 = head.next;
    	
    	ListNode tmp = pair2.next;
		
		pair2.next=pair1;
		pair1.next=tmp;
		pair1 = pair2;
		pair2 = head;
    	while (true) {
			
    		ListNode tmp1 = pair2.next;
    		
    		if(tmp1==null||tmp1.next==null) {
    			break;
    		}
    		ListNode pair3 = tmp1;
    		ListNode pair4 = pair3.next;
    		pair2.next = pair4;
    		ListNode tmp2 = pair4.next;
    		pair4.next = pair3;
    		pair3.next = tmp2;
    		
    		pair2 = pair3;
		}
    	return result;
    }
    public static void main(String[] args) {
    	
		int a = 0123;
		System.out.println(a);
		a = 0x123;
		System.out.println(a);
		a = 0b11111111;
		System.out.println(a);
		System.out.println(Integer.valueOf("0123"));
	}
}
