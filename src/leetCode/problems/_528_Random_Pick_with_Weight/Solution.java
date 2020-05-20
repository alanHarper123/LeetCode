package leetCode.problems._528_Random_Pick_with_Weight;

import java.util.Random;

public class Solution {
	private int[] w;
	private Random rand = new Random(System.currentTimeMillis());
    public Solution(int[] w) {
    	this.w = new int[w.length];
    	this.w[0] = w[0];
        for (int i = 1; i < w.length; i++) {
        	this.w[i]=this.w[i-1]+w[i];
		}
    }
    
    public int pickIndex() {
        int pick = rand.nextInt(w[w.length-1])+1;
        int start = 0,end = w.length;
        while (end>start) {
        	int mid = (end+start)/2;
        	if(w[mid]>pick)
        		end = mid;
        	else if(w[mid]<pick)
        		start = mid+1;
        	else 
				return mid;
		}
        return end;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
