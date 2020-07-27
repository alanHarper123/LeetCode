package leetCode.problems._845_Longest_Mountain_in_Array;

public class Solution {
    public int longestMountain(int[] A) {
    	int maxLength = 0;
        for (int i = 0; i < A.length;i++) {
        	while (i+1<A.length&&A[i+1]<=A[i]) {
				i++;
			}
        	int leftC = i;
        	while (i+1<A.length&&A[i+1]>A[i]) {
				i++;
			}
        	leftC = i-leftC+1;
        	if(leftC>1) {
        		int rightC = i;
        		while (i+1<A.length&&A[i+1]<A[i]) {
    				i++;
    			}
        		rightC = i-rightC;
        		if(rightC>0) {
        			if(rightC+leftC>maxLength)
        				maxLength = rightC+leftC;
        			i--;
        		}
        			
        	}
		}
        return maxLength;
    }
}
/*
845. Longest Mountain in Array
Medium

Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

    B.length >= 3
    There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]

(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.

Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.

Note:

    0 <= A.length <= 10000
    0 <= A[i] <= 10000

Follow up:

    Can you solve it using only one pass?
    Can you solve it in O(1) space?
 */