package leetCode.problems._1015_Smallest_Integer_Divisible_by_K;

import java.util.HashSet;

public class Solution {
    public int smallestRepunitDivByK(int K) {
    	if((K&1)==0)
        	return -1;
        int n = 1;
        int len = 1;     
        HashSet<Integer> remainders = new HashSet<>();
        while (true) {
        	while (n<K) {
				n=n*10+1;
				len++;
			}
        	n = n%K;
			if(n==0)
				return len;
			if(!remainders.add(n))
				return -1;
		}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().smallestRepunitDivByK(23));
	}
}
/*
1015. Smallest Integer Divisible by K
Medium

Given a positive integer K, you need find the smallest positive integer N such that N is divisible by K, and N only contains the digit 1.

Return the length of N.  If there is no such N, return -1.

 

Example 1:

Input: 1
Output: 1
Explanation: The smallest answer is N = 1, which has length 1.

Example 2:

Input: 2
Output: -1
Explanation: There is no such positive integer N divisible by 2.

Example 3:

Input: 3
Output: 3
Explanation: The smallest answer is N = 111, which has length 3.

 

Note:

    1 <= K <= 10^5
 */