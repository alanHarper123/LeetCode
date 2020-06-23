package leetCode.problems._718_Maximum_Length_of_Repeated_Subarray;

import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public int findLength(int[] A, int[] B) {
        int start = 1;
        int end = Math.min(A.length, B.length)+1;
        while (end>start) {
			int mid = (start+end)/2;
			if(findMatch(A, B, mid)) {
				start = mid+1;
			}else {
				end = mid;
			}
		}
        return end-1;
    }
    private boolean findMatch(int[] A, int[] B, int len) {
    	HashMap<Integer, LinkedList<Integer>> hashAToEnd = new HashMap<>(A.length-len+1);
    	int hashA = 0;
    	for (int i = 0; i < A.length; i++) {
			hashA+=A[i];
			if(i>=len) 
				hashA-=A[i-len];
			if(i>=len-1) {
				LinkedList<Integer> ends = hashAToEnd.get(hashA);
				if(ends==null) {
					ends = new LinkedList<>();
					hashAToEnd.put(hashA, ends);
				}
				ends.add(i);
			}
				
		}
    	return findMathUtil(A, B, len, hashAToEnd);
    }
    private boolean findMathUtil(int[] A, int[] B, int len,
    		HashMap<Integer, LinkedList<Integer>> hashAToEnd) {
    	int hashB = 0;
    	for (int i = 0; i < B.length; i++) {
			hashB+=B[i];
			if(i>=len) 
				hashB-=B[i-len];
			if(i>=len-1) {
				LinkedList<Integer> ends = hashAToEnd.get(hashB);
				if(ends!=null) {
					for(int end:ends) {
						if(isSubarrayEqual(A, B, len, end, i))
							return true;
					}
				}
	    	}
		}
    	return false;
    }
    private boolean isSubarrayEqual(int[] A, int[] B, int len,int endA,int endB) {
    	for (int i = endA,j=endB,count=0; count<len; i--,j--,count++) {
			if(A[i]!=B[j])
				return false;
		}
    	return true;
    }
}
/*
 Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].

 

Note:

    1 <= len(A), len(B) <= 1000
    0 <= A[i], B[i] < 100

 */
