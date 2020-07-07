package leetCode.problems._795_Number_of_Subarrays_with_Bounded_Maximum;

import java.util.LinkedList;

public class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int lowIndex = 0;
        int candidatesC = 0;
        int count = 0;
        int leftBount = A.length;
        int rightBount = 0;
        LinkedList<Integer> intervals = new LinkedList<>();
        for (int i = 0; i < A.length; i++) {
			if(A[i]>R) {
				if(leftBount!=A.length) {
					count+=calculate(lowIndex, i, candidatesC,
							leftBount, rightBount, intervals);
				}
				lowIndex = i+1;
				candidatesC=0;
				leftBount = A.length;
			}else if(A[i]>=L) {
				candidatesC++;
				if(leftBount==A.length)
					leftBount = i;
				else {
					if(i-rightBount-1>0)
						intervals.add(i-rightBount-1);
				}
				rightBount = i;
			}
		}
		if(leftBount!=A.length) {
			count+=calculate(lowIndex, A.length, candidatesC,
					leftBount, rightBount, intervals);
		}
        return count;
    }
    private int calculate(int lowIndex,int highIndex,int candidatesC,
    		int leftBount,int rightBount,LinkedList<Integer> intervals) {
    	int count = 0;
    	count+=candidatesC*(highIndex-lowIndex)-
				(candidatesC>1?(candidatesC*(candidatesC-1)/2):0);
		count+=(leftBount-lowIndex)*(highIndex-rightBount-1);
		int intervalSum = rightBount-leftBount+1-candidatesC;
		count+= (leftBount-lowIndex+highIndex-rightBount-1)*intervalSum;
		for (int interval:intervals) {
			intervalSum-=interval;
			count+=interval*intervalSum;
		}
		intervals.clear();
		return count;
    }

}
/*
We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input: 
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].

Note:

    L, R  and A[i] will be an integer in the range [0, 10^9].
    The length of A will be in the range of [1, 50000].
*/