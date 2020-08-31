package leetCode.problems._1005_Maximize_Sum_Of_Array_After_K_Negations;

import java.util.Arrays;

public class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        int sum=0,min=Integer.MAX_VALUE;
        for (int ai:A) {
			sum+=ai;
		}
        Arrays.sort(A);
        int i=0;
        while (K>0&&i<A.length&&A[i]<0) {
			K--;
			sum-=2*A[i];
			i++;
		}
        if((K&1)!=0) {
        	if(i==A.length) {
        		sum+=2*A[i-1];
        	}else {
        		if(i==0)
        			sum-=2*A[i];
        		else 
        			sum-=Math.min(2*A[i], -2*A[i-1]);
        	}
        }
        return sum;
    }
}
