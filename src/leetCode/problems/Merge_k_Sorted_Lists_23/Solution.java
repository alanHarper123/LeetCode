package leetCode.problems.Merge_k_Sorted_Lists_23;

import java.util.ArrayList;

// Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	ArrayList<ListNode> lns = new ArrayList<>();
    	for (int i = 0; i < lists.length; i++) {
    		if(lists[i]==null) {
    			continue;
    		}
			lns.add(lists[i]);
		}
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        if(lns.size()<1) {
        	return null;
        }
        if(lns.size()==1) {
        	return lns.get(0);
        }else {
			for (int i = lns.size()/2; i >=0 ; i--) {
				minimalize(lns, i);
			}
		}
        while (lns.size()>1) {
        	tempResult.val = lns.get(0).val;
        	tempResult.next = new ListNode(0);
        	tempResult = tempResult.next;
        	ListNode minNode = lns.get(0);
        	if(minNode.next!=null) {
        		lns.set(0, minNode.next);	
        	}else {
				lns.set(0, lns.get(lns.size()-1));
				lns.remove(lns.size()-1);
			}
        	minimalize(lns, 0);
		}
        tempResult.val = lns.get(0).val;
        tempResult.next = lns.get(0).next;
        return result;
    }
    
    private void minimalize(ArrayList<ListNode> lns, int bindex) {
    	while ((bindex+1)*2<=lns.size()) {
    		int minIndex = bindex;
			if(lns.get(minIndex).val>lns.get((bindex+1)*2-1).val) {
				minIndex = (bindex+1)*2-1;
			}
			if((bindex+1)*2<lns.size()&&lns.get(minIndex).val>lns.get((bindex+1)*2).val) {
				minIndex = (bindex+1)*2;
			}
			if(minIndex == bindex) {
				return;
			}else {
				ListNode temListNode = lns.get(minIndex);
				lns.set(minIndex, lns.get(bindex));
				lns.set(bindex, temListNode);
				bindex = minIndex;
			}
		}
    }
}

