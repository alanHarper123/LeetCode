package leetCode.problems._967_Numbers_With_Same_Consecutive_Differences;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        
        for (int i = 1; i < 10; i++) {
			backTrack(res, N-1, i, i, K);
		}
        if(N==1)
        	res.add(0);
        return res.stream().mapToInt(i->i).toArray();
    }
    private void backTrack(LinkedList<Integer> res,int N, int resEl, int dit,int K) {
    	if(N==0) {
    		res.add(resEl);
    		return;
    	}
    	if(K!=0) {
    		for (int i = -K,ditN; i <= K; i+=2*K) {
    			ditN = dit+i;
    			if(ditN>=0&&ditN<10) {
    				backTrack(res, N-1, resEl*10+ditN, ditN, K);
    			}
    		}
    	}else
    		backTrack(res, N-1, resEl*10+dit, dit, K);
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().numsSameConsecDiff(3,7)));
	}
}
/*
967. Numbers With Same Consecutive Differences
Medium

Return all non-negative integers of length N such that the absolute difference between every two consecutive digits is K.

Note that every number in the answer must not have leading zeros except for the number 0 itself. For example, 01 has one leading zero and is invalid, but 0 is valid.

You may return the answer in any order.

 

Example 1:

Input: N = 3, K = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.

Example 2:

Input: N = 2, K = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]

 

Note:

    1 <= N <= 9
    0 <= K <= 9
 */