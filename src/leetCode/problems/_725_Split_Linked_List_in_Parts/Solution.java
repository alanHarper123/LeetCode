package leetCode.problems._725_Split_Linked_List_in_Parts;

import leetCode.problems.commonUtil.ListNode;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] parts = new ListNode[k];
        int len = 0;
        ListNode runner = root;
        while (runner!=null) {
			len++;
			runner=runner.next;
		}
        int l1 = len/k;
        int pivot = len%k;
        runner = root;
        for (int i = 0; i < k&&runner!=null; i++) {
        	int curLen = l1+(i<pivot?1:0);
        	parts[i] = runner;
        	while (curLen>1&&runner!=null) {
				curLen--;
				runner = runner.next;
			}
        	if(runner!=null) {
            	ListNode temp = runner.next;
            	runner.next = null;
            	runner = temp;
        	}
		}
        return parts;
    }
}
