package leetCode.problems._460_LFU_Cache;

import java.util.HashMap;


class Node{
	int key;
	long fr;
	int val;
	Node pre;
	Node next;
	public Node(Integer key,int val) {
		this.key=key;
		this.val=val;
	}
}
public class LFUCache {
	private HashMap<Integer, Node> allNodes = new HashMap<>();
	private HashMap<Long, Node> frToTail = new HashMap<>();
	private Node minNode;
	int capacity;
	int count;
	public LFUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		Node target = allNodes.get(key);
		if(target == null)
			return -1;
		else {
			increaseFr(target);
			return target.val;
		}
	}
	private void increaseFr(Node target) {
		if(target==minNode&&target.next!=null) {
			if(target.next.fr<=minNode.fr+1)
				minNode = target.next;
		}
		long fr = target.fr;
		Node tail = frToTail.get(fr);
		if(target.pre!=null)
			target.pre.next = target.next;
		if(target.next!=null)
			target.next.pre = target.pre;
		if(target==tail) {
			if(tail.pre!=null&&tail.pre.fr==tail.fr) {
				frToTail.put(fr, tail.pre);
			}
			else 
				frToTail.remove(fr);
			tail = tail.pre;
		}

		Node nextTail = frToTail.get(fr+1);
		if(nextTail!=null) {
			addNodeToFrTail(nextTail, target);
		}else if(tail!=null){
			addNodeToFrTail(tail, target);
		}

		target.fr++;
		frToTail.put(target.fr,target);
	}
	private void addNodeToFrTail(Node tail,Node target) {
		target.next = tail.next;
		if(tail.next!=null)
			tail.next.pre=target;
		target.pre = tail;
		tail.next = target;
	}

	public void put(int key, int value) {
		if(capacity==0)
			return;
		Node target = allNodes.get(key);
		if(target==null) {
			count++;
			if(count>capacity) {
				count--;
				allNodes.remove(minNode.key);
				Node frTail = frToTail.get(minNode.fr);
				if(frTail==minNode) {
					frToTail.remove(minNode.fr);
				}
				minNode = minNode.next;
				if(minNode!=null)
					minNode.pre = null;

			}
			target = new Node(key, value);
			target.fr = 1;
			Node tail = frToTail.get(target.fr);
			if(tail==null) {
				target.next = minNode;
				if(minNode!=null)
					minNode.pre = target;
				minNode = target;
			}else {
				addNodeToFrTail(tail, target);
			}
			allNodes.put(target.key, target);
			frToTail.put(target.fr,target);
		}else {
			target.val = value;
			increaseFr(target);
		}
	}
	public static void main(String[] args) {
		LFUCache cache = new LFUCache( 2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1));       // returns 1
		cache.put(3, 3);    // evicts key 2
		System.out.println(cache.get(2));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		cache.put(4, 4);    // evicts key 1
		System.out.println(cache.get(1));       // returns -1 (not found)
		System.out.println(cache.get(3));       // returns 3
		System.out.println(cache.get(4));       // returns 4
		
		LFUCache cache2 = new LFUCache( 2 /* capacity */ );

		cache2.put(3, 1);
		cache2.put(2, 1);
		cache2.put(2, 2);    // evicts key 2
		cache2.put(4, 4);    // evicts key 1
		System.out.println(cache2.get(2));       // returns 4
	
		
		LFUCache cache3 = new LFUCache( 1 /* capacity */ );

		cache3.put(2, 1);
		System.out.println(cache3.get(2));
		cache3.put(3, 2);
		System.out.println(cache3.get(2));
		System.out.println(cache3.get(3));

	}
}
