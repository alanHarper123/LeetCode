package leetCode.problems._935_Knight_Dialer;

import java.util.Arrays;

public class Solution {
	int mod = 1000000000+7;
	int[][] dirs = new int[][] {{4,6},{6,8},{7,9},{4,8},{3,9,0},{},{1,7,0},{2,6},{1,3},{4,2}};
    public int knightDialer(int N) {
        int[] state = new int[10];
        int[] stateTemp = new int[10];
        int[] temp = new int[10];
        int[] dir;
        Arrays.fill(state, 1);
        while (N>1) {
        	N--;
        	Arrays.fill(temp, 0);
        	for (int i = 0; i < state.length; i++) {
				dir = dirs[i];
				for(int j:dir) {
					temp[j]+=state[i];
					if(temp[j]>=mod)
						temp[j]-=mod;
				}
			}
        	stateTemp = state;
			state = temp;
			temp = stateTemp;
		}
        int res = 0;
        for(int i:state) {
        	res+=i;
        	if(res>=mod)
        		res-=mod;
        }
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().knightDialer(3));
	}
}
/*
935. Knight Dialer
Medium

A chess knight can move as indicated in the chess diagram below:

 .           

 

This time, we place our chess knight on any numbered key of a phone pad (indicated above), and the knight makes N-1 hops.  Each hop must be from one key to another numbered key.

Each time it lands on a key (including the initial placement of the knight), it presses the number of that key, pressing N digits total.

How many distinct numbers can you dial in this manner?

Since the answer may be large, output the answer modulo 10^9 + 7.

 

Example 1:

Input: 1
Output: 10

Example 2:

Input: 2
Output: 20

Example 3:

Input: 3
Output: 46

 

Note:

    1 <= N <= 5000
 */