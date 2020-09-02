package leetCode.problems._1016_Binary_String_With_Substrings_Representing_1_To_N;

public class Solution {
    public boolean queryString(String S, int N) {
    	char[] chars = S.toCharArray();
    	int k;
        loop1:while (N>0) {
			int kBound = Integer.highestOneBit(N);
			k=1;
			int cur = 0;
			int i = chars.length-1;
			while (i>=0&&k<=kBound) {
				cur+=(chars[i]-'0')*k;
				k<<=1;
				i--;
			}
			if(k<kBound&&i<0)
				return false;
			if(cur==N) {
				N--;
				continue;
			}
			while (i>=0) {
				cur>>=1;
				cur+=(chars[i]-'0')*kBound;
				if(cur==N) {
					N--;
					continue loop1;
				}
				i--;
			}
			return false;
		}
        return true;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().queryString("0110", 4));
	}
}
/*
1016. Binary String With Substrings Representing 1 To N
Medium

Given a binary string S (a string consisting only of '0' and '1's) and a positive integer N, return true if and only if for every integer X from 1 to N, the binary representation of X is a substring of S.

 

Example 1:

Input: S = "0110", N = 3
Output: true

Example 2:

Input: S = "0110", N = 4
Output: false

 

Note:

    1 <= S.length <= 1000
    1 <= N <= 10^9
 */