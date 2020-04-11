package leetCode.problems._Min_Stack;

import java.util.LinkedList;

public class MinStack {
	private LinkedList<Integer> actualList = new LinkedList<>();
	private LinkedList<Integer> minVals = new LinkedList<>();
	private int currentMin = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        actualList.add(x);
        if(x<currentMin)
        	currentMin = x;
        minVals.add(currentMin);
    }
    
    public void pop() {
        actualList.pollLast();
        Integer min = minVals.pollLast();
        if(min==currentMin) {
        	if(minVals.size()!=0)
        		currentMin = minVals.peekLast();
        	else 
				currentMin = Integer.MAX_VALUE;
			
        }
    }
    
    public int top() {
        return actualList.peekLast();
    }
    
    public int getMin() {
        return minVals.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
