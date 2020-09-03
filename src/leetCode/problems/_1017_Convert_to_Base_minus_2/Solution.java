package leetCode.problems._1017_Convert_to_Base_minus_2;

import java.util.LinkedList;

public class Solution {
    public String baseNeg2(int N) {
    	if(N==0)
    		return "0";
        LinkedList<Integer> bits = new LinkedList<>();
        while (N>0) {
        	if((N&1)==0)
        		bits.add(0);
        	else 
        		bits.add(1);
			N>>=1;
		}
        StringBuilder res = new StringBuilder();
        boolean isOdd = false;
        int cur = 0;
        for(int bit:bits) {
        	cur+=bit;
        	if((cur&1)==1)
        		res.append(1);
        	else 
				res.append(0);
        	if(isOdd)
				cur++;
			cur>>=1;
			isOdd = !isOdd;
        }
        if(cur>0) {
        	res.append(1);
        	if(isOdd) 
        		res.append(1);	
        }
        	
        return res.reverse().toString();
    }
    public static void main(String[] args) {
		System.out.println(new Solution().baseNeg2(6));
	}
}
/*
1017. Convert to Base -2
Medium

Given a number N, return a string consisting of "0"s and "1"s that represents its value in base -2 (negative two).

The returned string must have no leading zeroes, unless the string is "0".

 

Example 1:

Input: 2
Output: "110"
Explantion: (-2) ^ 2 + (-2) ^ 1 = 2

Example 2:

Input: 3
Output: "111"
Explantion: (-2) ^ 2 + (-2) ^ 1 + (-2) ^ 0 = 3

Example 3:

Input: 4
Output: "100"
Explantion: (-2) ^ 2 = 4

 

Note:

    0 <= N <= 10^9
 */