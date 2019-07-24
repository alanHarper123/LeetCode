package leetCode.problems._148_Sort_List;

import leetCode.problems.commonUtil.ListNode;

class Solution {
	public ListNode sortList(ListNode head) {
		return quickSortList(head, null);
	}
	public ListNode quickSortList(ListNode head, ListNode tail) {
		if(head==null||head.next==tail) {
			return head;
		}
		ListNode headLeft = null;
		ListNode leftRunner = null;
		ListNode headRight = null;
		ListNode RightRunner = null;
		ListNode pivot = head;
		head=head.next;
		while (head!=tail) {
			if(head.val<pivot.val) {
				if(leftRunner==null) 
					headLeft = head;
				else 
					leftRunner.next=head;	

				leftRunner=head;
			}else {
				if(RightRunner == null) 
					headRight = head;
				else 
					RightRunner.next=head;
				RightRunner=head;
			}
			head=head.next;
		}
		if(leftRunner!=null) 
			leftRunner.next = pivot;
		if(RightRunner!=null) 
			RightRunner.next=tail;
		if(headRight!=null) {
			pivot.next=quickSortList(headRight,tail);
		}else 
			pivot.next=tail;
		if(headLeft!=null) 
			return quickSortList(headLeft,pivot);
		else 
			return pivot;	
	}
	public static void main(String[] args) {
		int[][] testsData = {
				{2,1},
				{1},
				{4,19,14,5,-3,1,8,5,11,15},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testsData.length; i++) {
			ListNode a = ListNode.buildListNode(testsData[i]);
			System.out.println(solution.sortList(a));
		}
	}
}
