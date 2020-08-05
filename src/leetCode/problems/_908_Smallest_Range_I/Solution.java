package leetCode.problems._908_Smallest_Range_I;

public class Solution {
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val:A) {
        	if(val<min)
        		min = val;
        	if(val>max)
        		max = val;
        }
        int dif = max - min;
        dif-=2*K;
        return dif>0?dif:0;
    }
}
