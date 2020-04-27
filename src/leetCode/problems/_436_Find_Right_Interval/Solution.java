package leetCode.problems._436_Find_Right_Interval;

import java.util.Arrays;

class Interval{
	public int[] interval;
	public int index;
	public Interval(int[] interval,int index) {
		this.index = index;
		this.interval = interval;
	}
}
public class Solution {
    public int[] findRightInterval(int[][] intervals) {
    	if(intervals==null)
    		return null;
    	int[] result = new int[intervals.length];
    	Interval[] nIntervals = new Interval[intervals.length];
    	
    	for (int i = 0; i < intervals.length; i++) {
			nIntervals[i] = new Interval(intervals[i], i);
		}
    	Interval[] endSequence = Arrays.copyOf(nIntervals,nIntervals.length);
    	Arrays.sort(endSequence,(ivl1,ivl2)->ivl1.interval[1]-ivl2.interval[1]);
    	Arrays.sort(nIntervals,(ivl1,ivl2)->ivl1.interval[0]-ivl2.interval[0]);
    	int uniqueC = 0;
    	for (int i = 0; i < nIntervals.length;) {
    		nIntervals[uniqueC] = nIntervals[i]; 
    		while (++i<nIntervals.length&&
    				nIntervals[uniqueC].interval[0]==nIntervals[i].interval[0]) {
    			if(nIntervals[uniqueC].index>nIntervals[i].index)
    				nIntervals[uniqueC] = nIntervals[i];
			}
    		uniqueC++;
		}
    	for (int i = result.length-1; i >=0;) {
    		int uniqueKeyEnd = endSequence[i].interval[1];
			int searchIndex = searchIntervals(nIntervals, uniqueKeyEnd, 0, uniqueC);
			int targetIndex;
			if (searchIndex==uniqueC)
				targetIndex = -1;
			else {
				uniqueC = searchIndex+1;
				targetIndex = nIntervals[searchIndex].index;
			}
			result[endSequence[i].index] = targetIndex;
			while (--i>=0&&uniqueKeyEnd==endSequence[i].interval[1]) {
				result[endSequence[i].index] = targetIndex;
			}
				
			
		}
    	return result;
    	
    }
    private int searchIntervals(Interval[] intervals,int keyEnd,int start,int end) {
    	int i=-1;
    	int vStart=start, vEnd = end;
    	while (vEnd>vStart) {
			i=(vStart+(vEnd-vStart)/2);
			if(intervals[i].interval[0]>keyEnd)
				vEnd = i;
			else if(intervals[i].interval[0]<keyEnd)
				vStart = i+1;
			else 
				return i;
		}
    	return vStart;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findRightInterval(new int[][] {{1,4},{2,3},{3,4}}));
	}
}
