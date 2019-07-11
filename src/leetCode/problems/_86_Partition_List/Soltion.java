package leetCode.problems._86_Partition_List;

import java.util.ArrayList;
import java.util.Iterator;

// Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class Solution {
	public ListNode partition(ListNode head, int x) {
		ListNode newHead = null;
		ListNode newHeadBackUp = null;
		ListNode firstHead = null;
		ListNode secondHead = null;
		while (head!=null) {
			if(head.val<x) {
				if(firstHead==null) {
					newHead = head;
					firstHead = head;
				}					
				else {
					firstHead.next = head;
					firstHead = head;
				}
			}else {
				if (secondHead == null) {
					newHeadBackUp=head;
					secondHead = head;
				}else {
					secondHead.next = head;
					secondHead = head;
				}
			}
			head = head.next;
		}
		if (firstHead!=null) 
			firstHead.next = newHeadBackUp;
		if(secondHead!=null)
			secondHead.next = null;
		return newHead!=null?newHead:newHeadBackUp;
	}
	public static void main(String[] args) {
		int[][] testdata = {
				{1,4,3,2,5,2},
				{1,2,3,3,4,4,5},
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
			ListNode newHead = solution.partition(listNode,5);
			while (newHead!=null) {
				System.out.println(newHead.val);
				newHead = newHead.next;
			}
			System.out.println("----------");
		}
	}
}
