package leetCode.problems._92_Reverse_Linked_List_II;

import java.util.ArrayList;
import java.util.Iterator;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode newHead = head;
		int count = 1;
		ListNode reverseToe = null;
		ListNode reverIterator = null;
		ListNode reverseHead = null;
		ListNode headConnector = null;
		ListNode toeConnector = null;
		while (head!=null) {
			ListNode temp = null;
			if(reverIterator!=null&&reverseHead==null) {
				temp = head.next;
				head.next = reverIterator;
				reverIterator = head;
			}	
			if(count==m-1) 
				headConnector = head;
			if(count == m) {
				reverIterator = head;
				reverseToe = head;
			}
			if(count == n) 
				reverseHead = head;
			if (count == n+1) {
				toeConnector = head;
				break;
			}
			if(count>m&&count<=n)
				head = temp;
			else head = head.next;
			count++;
		}
		if (headConnector!=null) 
			headConnector.next = reverseHead;
		else 
			newHead = reverseHead;
		reverseToe.next = toeConnector;
		return newHead;
	}
	public static void main(String[] args) throws InterruptedException {
		int[][] testdata = {
				{3,5},	
				{1,4,3,2,5,2},
				{1,2,3,6,4,4,5},
		};
		ArrayList<ListNode> testsArrayList = new ArrayList<>();
		for (int i = 0; i < testdata.length; i++) {
			ListNode test = new ListNode(testdata[i][0]);
			testsArrayList.add(test);
			for (int j = 1; j < testdata[i].length; j++) {
				ListNode newE = new ListNode(testdata[i][j]);
				test.next = newE;
				test = newE;
			}
		}
		
		Solution solution = new Solution();
		for (Iterator<ListNode> iterator = testsArrayList.iterator(); iterator.hasNext();) {
			ListNode listNode =  iterator.next();
			ListNode newHead = solution.reverseBetween(listNode,1,2);
			while (newHead!=null) {
				System.out.println(newHead.val);
//				Thread.sleep(1000);
				newHead = newHead.next;
			}
			System.out.println("----------");
		}
	}
}
