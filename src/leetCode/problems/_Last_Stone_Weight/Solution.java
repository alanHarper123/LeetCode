package leetCode.problems._Last_Stone_Weight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
       
        for (int i = 0; i < stones.length; i++) {
        	maxHeap.add(stones[i]);
		}
        
        while(maxHeap.size()>=2) {
        	int max = maxHeap.poll();
        	int sMax = maxHeap.poll();
        	if(max-sMax!=0)
        		maxHeap.add(max-sMax);
        }
        
        if(!maxHeap.isEmpty())
        	return maxHeap.poll();
        
        return 0;
    }
}
