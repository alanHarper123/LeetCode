package leetCode.problems._435_Non_overlapping_Intervals;

import java.util.Arrays;

public class Solution {
	public int eraseOverlapIntervals(int[][] intervals) {
		if(intervals==null||intervals.length<2)
			return 0;
		int count = -1;
		int minEnd = Integer.MAX_VALUE;
		Arrays.sort(intervals,(arr1,arr2)->arr1[0]-arr2[0]);
		for (int i = 0; i < intervals.length; i++) {
			if(intervals[i][0]<minEnd) {
				count++;
				if(intervals[i][1]<minEnd)
					minEnd = intervals[i][1];
			}
			else {
				minEnd = intervals[i][1];
			}
		}
		return count;
	}
}
