package leetCode.problems._945_Minimum_Increment_to_Make_Array_Unique;

import java.util.HashMap;

public class Solution {
	class Node{
		Node next;
		int val;
		public Node(int val) {
			this.val = val;
		}
	}
    public int minIncrementForUnique(int[] A) {
    	HashMap<Integer, Node> nodes = new HashMap<>();
        int count = 0;
        int val;
		Node node;
        for(int el:A) {
        	Node dup = nodes.get(el);
        	if(dup==null) {
        		val = el;
        		node = new Node(val);
        		nodes.put(val, node);
        		Node pre = nodes.get(val-1);
        		if(pre!=null) 
        			pre.next = node;
        	}else {    		
        		dup = getNext(dup);
        		val = dup.val+1;
        		node = new Node(val);
    			nodes.put(val, node);
    			dup.next = node;
        		count+=val-el;	
        	}
        	Node next = nodes.get(val+1);
    		if(next!=null) 
    			node.next = next;
    		
        }
        return count;
    }
    private Node getNext(Node node) {
    	if(node.next==null)
    		return node;
    	else 
    		node.next = getNext(node.next);
    	return node.next;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().minIncrementForUnique(new int[] {7,2,7,2,1,4,3,1,4,8}));
	}
}
