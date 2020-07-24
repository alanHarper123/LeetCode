package leetCode.problems._869_Reordered_Power_of_2;

import java.util.Arrays;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        char[] chars = String.valueOf(N).toCharArray();
        Arrays.sort(chars);
        int k = 1;
        while (true) {
        	if(k<0)
        		return false;
        	char[] newChars = String.valueOf(k).toCharArray();
        	if(newChars.length>chars.length)
        		return false;
        	if(newChars.length==chars.length) {
        		Arrays.sort(newChars);
        		if(isEqual(newChars, chars))
        			return true;
        	}
        	k<<=1;
		}
    }
    private boolean isEqual(char[] newChars,char[] chars) {
    	for (int i = 0; i < chars.length; i++) {
			if(chars[i]!=newChars[i])
				return false;
		}
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().reorderedPowerOf2(10));
	}
}
/*
869. Reordered Power of 2
Medium

Starting with a positive integer N, we reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this in a way such that the resulting number is a power of 2.

 

Example 1:

Input: 1
Output: true

Example 2:

Input: 10
Output: false

Example 3:

Input: 16
Output: true

Example 4:

Input: 24
Output: false

Example 5:

Input: 46
Output: true

 

Note:

    1 <= N <= 10^9
 */