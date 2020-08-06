package leetCode.problems._915_Partition_Array_into_Disjoint_Intervals;

import leetCode.problems.commonUtil.Sorting;

public class Solution {
    public int partitionDisjoint001(int[] A) {
        int[] index = new int[A.length];
        for (int i = 1; i < index.length; i++) {
        	index[i] = i;
		}
        Sorting.sortArr1(A, index, 0, A.length);
        int right = 0;
        for (int i = 0; i < index.length; i++) {
			right = Math.max(right, index[i]);
			if(i==right)
				return right+1;
		}
        return -1;
    }
    public int partitionDisjoint(int[] A) {
        int[] LeftMax = new int[A.length];
        int[] rightMin = new int[A.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
			if(A[i]>max)
				max = A[i];
			LeftMax[i] = max;
		}
        int min = Integer.MAX_VALUE;
        for (int i = A.length-1; i > 0; i--) {
			if(A[i]<min)
				min = A[i];
			rightMin[i] = min;
		}
        for (int i = 1; i < rightMin.length; i++) {
			if(LeftMax[i-1]<=rightMin[i])
				return i;
		}
        return -1;
    }
}
/*
915. Partition Array into Disjoint Intervals
Medium

Given an array A, partition it into two (contiguous) subarrays left and right so that:

    Every element in left is less than or equal to every element in right.
    left and right are non-empty.
    left has the smallest possible size.

Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

 

Example 1:

Input: [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:

Input: [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

 

Note:

    2 <= A.length <= 30000
    0 <= A[i] <= 10^6
    It is guaranteed there is at least one way to partition A as described.
 */