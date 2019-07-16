package leetCode.problems._109_Convert_Sorted_List_to_Binary_Search_Tree;

import leetCode.problems.commonUtil.ListNode;
import leetCode.problems.commonUtil.TreeNode;

public class Solution {
	private ListNode runner;
    public TreeNode sortedListToBST(ListNode head) {
        runner = head;
        return sortedListToBST(countSize(head));
    }
    private int countSize(ListNode head) {
    	int size=0;
    	while (head!=null) {
			head=head.next;
			size++;
		}
    	return size;
    }
    private TreeNode sortedListToBST(int n) {
    	if(n==0)
    		return null;
    	TreeNode node = new TreeNode(0);
    	node.left = sortedListToBST(n/2);
    	node.val = runner.val;
    	runner = runner.next;
    	node.right = sortedListToBST(n-n/2-1);
    	return node;
    }
}
