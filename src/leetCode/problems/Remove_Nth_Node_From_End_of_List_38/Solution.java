package leetCode.problems.Remove_Nth_Node_From_End_of_List_38;

import java.util.ArrayList;




// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		ListNode head = this;
		do {
			sb.append(head.val);
			sb.append(",");
			head = head.next;
		}while (head!=null);
		sb.deleteCharAt(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
}

class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		
		ArrayList<ListNode> ref = new ArrayList<>();
		ref.add(head);
		while (head.next!=null) {
			ref.add(head.next);
			head = head.next;
		}
		if(ref.size()==n) {
			return ref.get(0).next;
		}
		ref.get(ref.size()-n-1).next = (n==1 ? null : ref.get(ref.size()-n+1));
		return ref.get(0);
	}
//	public static void main(String[] args) {
//		ListNode head = new ListNode();
//		head.val = 1;
//		ListNode temp1 = head;
//		for (int i = 2; i < 6; i++) {
//			ListNode temp = new ListNode();
//			temp.val = i;
//			head.next = temp;
//			head = temp;
//		}
//		System.out.println(temp1);
//		System.out.println(new Solution().removeNthFromEnd(temp1, 2));
//	}
}
