package leetCode.problems.commonUtil;

// Definition for singly-linked list.
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int x) { val = x; }
	public static ListNode buildListNode(int[] list) {
		ListNode root = null;
		ListNode runner = null;
		for (int i = 0; i < list.length; i++) {
			ListNode e = new ListNode(list[i]);
			if(root==null) {
				root = e;
			}else {
				runner.next = e;
			}
			runner = e;
		}
		return root;
	}
	@Override
	public String toString() {
		String s = "[";
		ListNode runner = this;
		while (runner!=null) {
			if(!s.endsWith("[")) {
				s+=","+runner.val;
			}else {
				s+=runner.val;
			}
			runner=runner.next;
		}
		s+="]";
		return s;
	}
}
