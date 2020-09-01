package leetCode.problems._1004_Max_Consecutive_Ones_III;

import java.util.ArrayList;

public class Solution {
    public int longestOnes(int[] A, int K) {
        int max = 0;
        int[] counts = new int[A.length];
        int ci=0;
        if(A[0]==1)
        	counts[ci++] = 0;
        int vCount = 0;
        for (int i = 0,c=0,val; i < A.length; i++) {
        	c=i;
        	val = A[i];
			while (i+1<A.length&&A[i+1]==val) {
				i++;
			}
			c = i-c+1;
			if(val==0)
				vCount+=c;
			counts[ci++] = c;
		}
        if(K>=vCount)
        	return A.length;
        vCount-=counts[0];
        if(K>=vCount)
        	return A.length-counts[0]+K-vCount;
        int i=1;
        int ki=2;
        int count = 0;
        if(ci==1)
        	return K;
        else 
			count = counts[1];
        int plen = counts[0],val;
        while (true) {
			while ((val=counts[ki])<=K) {
				count+=val;
				K-=val;
				vCount-=val;
				count+=counts[ki+1];
				ki+=2;
			}
			if(count+K>max)
				max = count+K;
			
			plen+=counts[i];
			count-=counts[i];
			plen+=counts[i+1];
			if(ki!=i+1) {
				K+=counts[i+1];
				count-=counts[i+1];
			}else {
				vCount -= counts[i+1];
				ki+=2;
			}			
			if(K>=vCount)
				return Math.max(max, A.length-plen+K-vCount);
			i+=2;
		}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
	}
}
/*
1004. Max Consecutive Ones III
Medium

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

 

Example 1:

Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:

Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

 

Note:

    1 <= A.length <= 20000
    0 <= K <= A.length
    A[i] is 0 or 1 
 */