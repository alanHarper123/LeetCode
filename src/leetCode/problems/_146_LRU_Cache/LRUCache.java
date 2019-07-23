package leetCode.problems._146_LRU_Cache;

import java.util.HashMap;

class DoubleLinkedList{
	DoubleLinkedList next;
	DoubleLinkedList pre;
	int key;
	int val;
	public DoubleLinkedList(int key,int val,DoubleLinkedList pre,
			DoubleLinkedList next) {
		if(pre!=null)
			pre.next = this;
		if(next!=null)
			next.pre = this;
		this.key=key;
		this.val = val;
		this.pre = pre;
		this.next = next;
	}
}

public class LRUCache {
	HashMap<Integer, DoubleLinkedList> inventory;
	int capacity;
	DoubleLinkedList head;
	DoubleLinkedList tail;
    public LRUCache(int capacity) {
    	inventory = new HashMap<>(capacity);
    	this.capacity = capacity;
    }
    
    public int get(int key) {
    	DoubleLinkedList re = inventory.get(key);
    	if(re==null)
    		return -1;
    	else {
    		priorityRearange(re);
    		return re.val;
    	}
    }
    
    public void put(int key, int value) {
    	DoubleLinkedList re = inventory.get(key);
    	if(re==null) {
    		re = new DoubleLinkedList(key,value,tail,null);
    		if(inventory.size()==capacity) {
    			inventory.remove(head.key);
    			head = head.next;
    			if(head!=null) {
    				head.pre = null;
    			}
    		}
    		if(head==null) {
    			head = re;
    		}
    		tail = re;
    		inventory.put(key, re);
    	}else {
    		re.val = value;
    		priorityRearange(re);
    	}
    	
    }
    private void priorityRearange(DoubleLinkedList re) {
    	if(tail==re)
    		return;
    	DoubleLinkedList pre = re.pre;
    	DoubleLinkedList next = re.next;
    	if(pre!=null) {
    		pre.next = next;
    	}else {
    		head = next;
    	}	
    	if(next!=null)
    		next.pre = pre;
    	if(tail!=null) 
    		tail.next = re;
    	re.pre = tail;
    	re.next=null;
    	tail = re;
    	if(head==null)
    		head=re;
    }
    public static void main(String[] args) {
    	LRUCache cache = new LRUCache( 2 /* capacity */ );

    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));       // returns 4
    	
    	System.out.println("---------------");
    	cache = new LRUCache( 1 /* capacity */ );

    	cache.put(2, 1);
    	System.out.println(cache.get(2));       // returns 1
    	cache.put(3, 2);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 2
    	
    	System.out.println("---------------");
    	cache = new LRUCache( 2 /* capacity */ );

    	cache.put(2, 1);
    	cache.put(3, 2);
    	System.out.println(cache.get(3));       // returns 2
    	System.out.println(cache.get(2));       // returns 1
    	cache.put(4, 3);    // evicts key 1
    	System.out.println(cache.get(2));       // returns 1
    	System.out.println(cache.get(3));       // returns -1
    	System.out.println(cache.get(4));       // returns 3
	}
}
