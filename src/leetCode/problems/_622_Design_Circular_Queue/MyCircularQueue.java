package leetCode.problems._622_Design_Circular_Queue;

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
public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
	private DoubleLinkedNode head;
	private int size=0;
	private int capacity;
    public MyCircularQueue(int k) {
    	capacity = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size<capacity) {
        	size++;
        	DoubleLinkedNode newHead = new DoubleLinkedNode(head==null?null:head.pre, head, value);
        	head = newHead;
        	if(head.pre==null) {
        		head.pre = head;
        		head.next = head;
        	}
        	return true;
        }
        return false;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size>0) {
        	size--;
        	if(size==0) {
        		head = null;
        	}else {
        		head.pre = head.pre.pre;
            	head.pre.next = head;
        	}
        	
        	return true;
        }
        return false;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	return head==null?-1:head.pre.val;
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	return head==null?-1:head.val;
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size==0;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
