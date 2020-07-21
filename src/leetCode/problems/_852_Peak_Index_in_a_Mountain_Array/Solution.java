package leetCode.problems._852_Peak_Index_in_a_Mountain_Array;

public class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int i = 0;
        while (i+1<A.length&&A[i+1]>A[i]) {
        	i++;
		}
        return i;
    }
}
