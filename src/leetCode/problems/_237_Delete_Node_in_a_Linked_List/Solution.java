package leetCode.problems._237_Delete_Node_in_a_Linked_List;

import leetCode.problems.commonUtil.ListNode;

public class Solution {

	public void deleteNode(ListNode node) {
		if(node==null||node.next==null)
			return;
		while (node.next!=null) {
			node.val = node.next.val;
			if(node.next.next!=null)
				node=node.next;
			else {
				node.next=null;
			}
		}
	}

}
