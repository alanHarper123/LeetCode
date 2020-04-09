package leetCode.problems._382_Linked_List_Random_Node;

import java.util.HashMap;
import java.util.Random;

import leetCode.problems.commonUtil.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
	private HashMap<Integer, Integer> keytoValue;
	private int count;
	private Random rand = new Random(System.currentTimeMillis());
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
    	keytoValue = new HashMap<>();
    	this.count = 0;
        while (head!=null) {
			keytoValue.put(count++, head.val);
			head = head.next;
		}
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
    	return keytoValue.get(rand.nextInt(count));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */