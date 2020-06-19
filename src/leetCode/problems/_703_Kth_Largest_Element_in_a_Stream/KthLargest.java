package leetCode.problems._703_Kth_Largest_Element_in_a_Stream;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargest {
	private PriorityQueue<Integer> pq = new PriorityQueue<>();
	private int k;
    public KthLargest(int k, int[] nums) {
    	this.k=k;
    	if(k<nums.length) {
    		Arrays.sort(nums);
    	}
        for (int i = k-1; i >=0; i--) {
        	if(nums.length-1-i>=0)
        		pq.add(nums[nums.length-1-i]);
		}
    }
    
    public int add(int val) {
    	if(pq.size()==k) {
    		int kth = pq.peek();
            if(kth>val) {
            	return kth;
            }else {
            	pq.add(val);
            	pq.poll();
            	return pq.peek();
            }
    	}else {
    		pq.add(val);
        	return pq.peek();
    	}
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
