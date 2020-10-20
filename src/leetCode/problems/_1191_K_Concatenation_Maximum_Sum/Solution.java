package leetCode.problems._1191_K_Concatenation_Maximum_Sum;

public class Solution {
	int mod = 1000000000+7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        int sum=0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
        	int val = sum+arr[i];
			if(val-min>max)
				max = val-min;
			sum = val;
			if(val<min)
				min = val;
		}
        if(k==1)
        	return max;
        int maxA = max;
        int sumA = sum;
        max = 0;
        for (int i = 0; i < arr.length; i++) {
        	int val = sum+arr[i];
			if(val-min>max)
				max = val-min;
			sum = val;
		}
        if(sumA>0&&k>2) {
        	long total = (long)(k-2)*sumA+max;
        	if(total>maxA)
        		return (int) (total%mod);
        	else 
				return maxA;
        }
        return Math.max(maxA, max);
    }
}
/*
1191. K-Concatenation Maximum Sum
Medium

Given an integer array arr and an integer k, modify the array by repeating it k times.

For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].

Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.

As the answer can be very large, return the answer modulo 10^9 + 7.

 

Example 1:

Input: arr = [1,2], k = 3
Output: 9

Example 2:

Input: arr = [1,-2,1], k = 5
Output: 2

Example 3:

Input: arr = [-1,-2], k = 7
Output: 0

 

Constraints:

    1 <= arr.length <= 10^5
    1 <= k <= 10^5
    -10^4 <= arr[i] <= 10^4

*/