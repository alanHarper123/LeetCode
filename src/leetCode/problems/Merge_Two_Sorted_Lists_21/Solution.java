package leetCode.problems.Merge_Two_Sorted_Lists_21;



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        while (l1!=null||l2!=null) {
			if(l1==null||(l2!=null&&l1.val>=l2.val)) {
				temp.next = new ListNode(l2.val);
				l2 = l2.next;	
			}else {
				temp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
			temp = temp.next;
			
		}
        return listNode.next;
    }
}
