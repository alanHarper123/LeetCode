package leetCode.problems._641_Design_Circular_Deque;

class DoubleLinkedNode{
	int val;
	DoubleLinkedNode pre;
	DoubleLinkedNode next;
	public DoubleLinkedNode(DoubleLinkedNode pre, DoubleLinkedNode next,int val) {
		this.val = val;
		this.pre = pre;
		this.next = next;
		if(pre!=null)
			pre.next = this;
		if(next!=null)
			next.pre = this;
	}
}
public class MyCircularDeque {

    /** Initialize your data structure here. Set the size of the deque to be k. */
	private DoubleLinkedNode head;
	private int size=0;
	private int capacity;
    public MyCircularDeque(int k) {
    	capacity = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(size<capacity) {
        	size++;
        	DoubleLinkedNode newHead = new DoubleLinkedNode(
        			head==null?null:head.pre, head, value);
        	head = newHead;
        	if(size==1) {
        		head.next = head;
        		head.pre = head;
        	}
        	return true;
        }
        return false;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if(size<capacity) {
    		size++;
    		DoubleLinkedNode newTail = new DoubleLinkedNode(
        			head==null?null:head.pre, head, value);
        	if(size==1) {
        		head = newTail;
        		head.next = head;
        		head.pre = head;
        	}
        	return true;
        }
        return false;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(size>0) {
        	if(size==1)
        		head=null;
        	else {
        		head.pre.next = head.next;
        		head.next.pre = head.pre;
        		head = head.next;
        	}
        	size--;
        	return true;
        }
        return false;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if(size>0) {
        	if(size==1)
        		head=null;
        	else {
        		head.pre.pre.next = head;
        		head.pre = head.pre.pre;
        	}
        	size--;
        	return true;
        }
        return false;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        return head==null?-1:head.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        return head==null?-1:head.pre.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==capacity;
    }
}
