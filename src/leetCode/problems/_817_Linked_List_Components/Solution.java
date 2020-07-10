package leetCode.problems._817_Linked_List_Components;

import java.util.HashSet;

import leetCode.problems.commonUtil.ListNode;

public class Solution {
    public int numComponents(ListNode head, int[] G) {
    	ListNode runner = head;
    	int n = 0;
    	while (runner!=null) {
			n++;
			runner = runner.next;
		}
        boolean[] isNodeExited = new boolean[n];
        for(int gi:G)
        	isNodeExited[gi]=true;

        int count = G.length;
        while (head.next!=null) {
			if(isNodeExited[head.val]&&isNodeExited[head.next.val])
				count--;
			head = head.next;
		}
        return count;
    }
}
