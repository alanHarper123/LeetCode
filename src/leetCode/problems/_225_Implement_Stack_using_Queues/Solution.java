package leetCode.problems._225_Implement_Stack_using_Queues;

import java.util.LinkedList;

class MyStack {
	private LinkedList<Integer> myList;
    /** Initialize your data structure here. */
    public MyStack() {
        myList = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        myList.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
       return myList.removeLast();
    }
    
    /** Get the top element. */
    public int top() {
        return myList.getLast();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myList.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
