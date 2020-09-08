package leetCode.problems._1031_Maximum_Sum_of_Two_Non_Overlapping_Subarrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        int[] sumi = new int[A.length+1];
        for (int i = 1; i < sumi.length; i++) {
			sumi[i] = A[i-1]+sumi[i-1];
		}
        PriorityQueue<Integer> sumQ = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;
        int len = L;
        int ls = sumi[L];
        for (int i = L+M; i < sumi.length; i++) {
			sumQ.add(sumi[i]-sumi[i-M]);
		}
        Integer ms=sumQ.peek();
        if(ls+ms>max) {
        	max = ls+ms;
        }
        for (int i = L+1,j=L+M,k=1; i < sumi.length; i++,j++,k++) {
			ls = sumi[i] - sumi[i-L];
			if(j<sumi.length) 
				sumQ.remove(sumi[j]-sumi[i-1]);
			if(k-M>=0) 
				sumQ.add(sumi[k]-sumi[k-M]);
			ms=sumQ.peek();
			if(ms!=null&&ls+ms>max){
	        	max = ls+ms;
	        }
		}
        return max;
    }
}
