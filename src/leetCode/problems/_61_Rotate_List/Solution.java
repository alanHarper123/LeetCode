package leetCode.problems._61_Rotate_List;

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if(k<=0||head==null||head.next==null) 
			return head;
		int length = 0;
		ListNode headTemp = head;
		ListNode toe = null;
		ListNode newHead = null;
		ListNode newToe = null;
		while (headTemp!=null) {
			toe = headTemp;
			length++;
			headTemp=headTemp.next;
		}
		if(k%length==0) 
			return head;
		k %= length;
		
		k = length - k;
		headTemp = head;
		int index = 1;
		while (headTemp.next!=null) {
			newToe = headTemp;
			headTemp = headTemp.next;
			if(k==index) {
				newHead = headTemp;
				break;
			}
			index++;
		}
		newToe.next=null;
		toe.next = head;
		return newHead;
	}

	public static void main(String[] args) {
		ListNode test = new ListNode(1);
		ListNode head = test;
		for (int i = 2; i < 6; i++) {
			ListNode newE = new ListNode(i);
			test.next = newE;
			test = newE;
		}
		Solution solution = new Solution();
		ListNode newHead = solution.rotateRight(head, 2);
		while (newHead!=null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}
}
