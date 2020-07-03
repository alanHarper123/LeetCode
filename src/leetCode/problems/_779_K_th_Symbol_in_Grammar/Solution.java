package leetCode.problems._779_K_th_Symbol_in_Grammar;

public class Solution {
    public int kthGrammar(int N, int K) {
    	K--;
    	N--;
    	int start = 0, end = (1<<N)-1, mid;
    	int val = 0;
        while (N>0) {
			N--;
			mid = start+(end-start)/2;
			if(K>mid) {
				val = 1-val;
				start=mid+1;
			}else {
				end = mid;
			}
		}
        return val;
    }
}

/*
779. K-th Symbol in Grammar
Medium

On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.

Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).

Examples:
Input: N = 1, K = 1
Output: 0

Input: N = 2, K = 1
Output: 0

Input: N = 2, K = 2
Output: 1

Input: N = 4, K = 5
Output: 1

Explanation:
row 1: 0
row 2: 01
row 3: 0110
row 4: 01101001

Note:

    N will be an integer in the range [1, 30].
    K will be an integer in the range [1, 2^(N-1)].


 */
