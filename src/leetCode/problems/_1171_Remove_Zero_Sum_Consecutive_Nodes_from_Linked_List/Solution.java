package leetCode.problems._1171_Remove_Zero_Sum_Consecutive_Nodes_from_Linked_List;

import java.util.HashMap;

import leetCode.problems.commonUtil.ListNode;

public class Solution {
	public ListNode removeZeroSumSublists(ListNode head) {
		HashMap<Integer, ListNode> men = new HashMap<>();
		int sum = 0;
		ListNode runner = head;
		men.put(0, null);
		while (runner!=null) {
			sum+=runner.val;
			if(men.containsKey(sum)) {
				ListNode newRunner = sum==0?head:men.get(sum).next;
				int sumT = sum;
				while (newRunner!=runner) {
					sumT+=newRunner.val;
					men.remove(sumT);
					newRunner = newRunner.next;
				}
				if(sum==0) 
					head = runner.next;
				else 
					men.get(sum).next = runner.next;
			}
			else 
				men.put(sum, runner);
			runner = runner.next;
		}
		return head;
	}
	public static void main(String[] args) {
		int[] testD = new int[] {1,0,0,-1,2,-1,0};
		ListNode head = null;
		for (int i = testD.length-1; i >=0; i--) {
			ListNode listNode = new ListNode(testD[i]);
			listNode.next = head;
			head = listNode;
		}
		System.out.println(new Solution().removeZeroSumSublists(head));
	}
}
/*
1171. Remove Zero Sum Consecutive Nodes from Linked List
Medium

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.

After doing so, return the head of the final linked list.  You may return any such answer.

 

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.

Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]

Example 3:

Input: head = [1,2,3,-3,-2]
Output: [1]

 

Constraints:

    The given linked list will contain between 1 and 1000 nodes.
    Each node in the linked list has -1000 <= node.val <= 1000.

*/