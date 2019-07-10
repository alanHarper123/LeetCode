package leetCode.problems._82_Remove_Duplicates_from_Sorted_List_II;

import java.util.ArrayList;
import java.util.Iterator;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
   public ListNode deleteDuplicates(ListNode head) {
   	ListNode interator = head;
   	if(interator==null)
   		return null;
   	ListNode temp = null;
   	ListNode lastUni = interator;
   	while (interator!=null) {
			interator = interator.next;
			if(interator!=null && interator.val==lastUni.val) {
				while (interator!=null && interator.val==lastUni.val) {
					interator = interator.next;
				}
				if(temp == null) {
					head = interator;
				}
			}else {
				if(temp!=null)
					temp.next = lastUni;
				temp = lastUni;
			}
			lastUni = interator;
		}
   	if(temp!=null)
   		temp.next=null;
   	return head;
   }
	public static void main(String[] args) {
		int[][] testdata = {
				{1,2,2},
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
			ListNode newHead = solution.deleteDuplicates(listNode);
			while (newHead!=null) {
				System.out.println(newHead.val);
				newHead = newHead.next;
			}
			System.out.println("----------");
		}
	}
}
