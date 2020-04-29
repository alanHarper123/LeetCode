package leetCode.problems._445_Add_Two_Numbers_II;

//Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String num1 = buildString(l1);
		String num2 = buildString(l2);
		if(num1.length()<num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		int diff = num1.length() - num2.length();
		StringBuilder zeroBuffer = new StringBuilder();
		for (int i = 0; i < diff; i++) {
			zeroBuffer.append(0);
		}
		num2 = zeroBuffer.append(num2).toString();
		boolean isUpgraded = false;
		ListNode head = null;
		for (int i = 1; i <= num2.length(); i++) {
			int sumi = (num1.charAt(num1.length()-i)-'0')
					+(num2.charAt(num2.length()-i)-'0')+(isUpgraded?1:0);
			if(sumi>=10) {
				sumi -= 10;
				isUpgraded = true;
			}else {
				isUpgraded = false;
			}
			
			ListNode newHead = new ListNode(sumi, head);
			head = newHead;
		}
		if(isUpgraded) {
			ListNode newHead = new ListNode(1, head);
			head = newHead;
		}	
		return head;
	}
	private String buildString(ListNode ln) {
		StringBuilder numSBuilder = new StringBuilder();
		while (ln!=null) {
			numSBuilder.append(ln.val);
		ln=ln.next;
		}
		return numSBuilder.toString();
	}
}
	