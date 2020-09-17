package leetCode.problems._1073_Adding_Two_Negabinary_Numbers;

import java.util.Arrays;

public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        if(arr1.length>arr2.length) {
        	int[] temp = arr1;
        	arr1 = arr2;
        	arr2 = temp;
        }
        int upgrade = 0;
        for (int i = 1; i <= arr1.length; i++) {
			int cur=arr1[arr1.length-i]+arr2[arr2.length-i];
			if(cur!=0) {
				if(upgrade==3) {
					upgrade = 0;
					cur--;
				}
			}
			cur+=upgrade&1;
			arr2[arr2.length-i] = cur&1;
			upgrade>>=1;
        	cur>>=1;
        	if(cur!=0)
        		upgrade=3;
		}
        for (int i = arr1.length+1; i <= arr2.length; i++) {
			int cur=arr2[arr2.length-i];
			if(cur!=0) {
				if(upgrade==3) {
					upgrade = 0;
					cur--;
				}
			}
			cur+=upgrade&1;
			arr2[arr2.length-i] = cur&1;
			upgrade>>=1;
        	cur>>=1;
        	if(cur!=0)
        		upgrade=3;
		}
        if(upgrade!=0) {
        	int[] res = new int[arr2.length+2];
        	res[0] = 1;
        	res[1] = 1;
        	for (int i = 2; i < res.length; i++) {
				res[i] = arr2[i-2];
			}
        	return res;
        }
        int i = 0;
        for (; i < arr2.length; i++) {
			if(arr2[i]!=0)
				break;
		}
        if(i==0)
        	return arr2;
        else if(i==arr2.length)
        	return new int[] {0};
        else 
			return Arrays.copyOfRange(arr2, i,arr2.length);
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().addNegabinary(new int[] {1}, new int[] {1})));
	}
}
/*
*
1073. Adding Two Negabinary Numbers
Medium

Given two numbers arr1 and arr2 in base -2, return the result of adding them together.

Each number is given in array format:  as an array of 0s and 1s, from most significant bit to least significant bit.  For example, arr = [1,1,0,1] represents the number (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array format is also guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.

Return the result of adding arr1 and arr2 in the same format: as an array of 0s and 1s with no leading zeros.

 

Example 1:

Input: arr1 = [1,1,1,1,1], arr2 = [1,0,1]
Output: [1,0,0,0,0]
Explanation: arr1 represents 11, arr2 represents 5, the output represents 16.

 

Note:

    1 <= arr1.length <= 1000
    1 <= arr2.length <= 1000
    arr1 and arr2 have no leading zeros
    arr1[i] is 0 or 1
    arr2[i] is 0 or 1

*/