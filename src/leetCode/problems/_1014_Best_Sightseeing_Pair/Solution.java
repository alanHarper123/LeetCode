package leetCode.problems._1014_Best_Sightseeing_Pair;

public class Solution {
	public int maxScoreSightseeingPair(int[] A) {
		for (int i = 1; i < A.length; i++) {
			A[i]-=i;
		}
		int[] maxs = new int[A.length];
		int max = Integer.MIN_VALUE;
		for (int i = A.length-1; i >=0; i--) {
			maxs[i] = max;
			if(A[i]>max)
				max = A[i];
		}
		max = 0;
		for (int i = 0,val; i < maxs.length-1; i++) {
			val = A[i]+2*i+maxs[i];
			if(val>max)
				max = val;
		}
		return max;
	}
}
/*
1014. Best Sightseeing Pair
Medium

Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.

The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

 

Example 1:

Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11

 

Note:

    2 <= A.length <= 50000
    1 <= A[i] <= 1000
 */