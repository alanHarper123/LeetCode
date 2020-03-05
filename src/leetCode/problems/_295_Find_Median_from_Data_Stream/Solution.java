package leetCode.problems._295_Find_Median_from_Data_Stream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {
	private Integer middle = null;
	private Double median = null;
	private PriorityQueue<Integer> minQ = new PriorityQueue<>();
	
	private PriorityQueue<Integer> MaxQ = new PriorityQueue<>(new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {return Integer.compare(o2, o1);};
	});;
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
    	if(median != null) {
    		if(num>median) {
    			minQ.add(num);
        		if(middle!=null) {
        			MaxQ.add(middle);
        			middle = null;
        		}else {
        			middle = minQ.poll();
        		}	
    		}else {
    			MaxQ.add(num);
    			if(middle!=null) {
    				minQ.add(middle);
    				middle = null;
    			}else {
    				middle = MaxQ.poll();
    			}	
    		}	
    	}else {
    		middle = num;
    	}
    	
    	if(middle!=null) {
    		median = (double)middle;
    	}else {
    		median= MaxQ.peek()+(double)(minQ.peek()-MaxQ.peek())/2;
		}
    }
    
    public double findMedian() {
    	return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */