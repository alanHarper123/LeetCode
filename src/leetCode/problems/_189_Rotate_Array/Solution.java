package leetCode.problems._189_Rotate_Array;

import java.util.Arrays;

public class Solution {
	public void rotate(int[] nums, int k) {
		k%=nums.length;
		boolean reversed = false;
		int start = -1;
		int length = nums.length;
		if(k>nums.length/2) {
			reversed = true;
			k = nums.length-k;
		}
		int i;
		int ie;
		int temp;
		while (k!=0) {
			i=reversed?(start+1):(start+length);
			ie=reversed?(start+length+1):(start);
			for (;(reversed&&i+k!=ie)||(!reversed&&i-k!=ie);) {
				if(reversed) {
					temp = nums[i+k];
					nums[i+k]=nums[i];
					nums[i]=temp;
					i++;
				}else {
					temp = nums[i-k];
					nums[i-k]=nums[i];
					nums[i]=temp;
					i--;
				}
			}
			int lengthTp = length;
			length=k;
			k=lengthTp%k;
			if(reversed==true) {
				start = start+lengthTp-length;
				if(k>length/2) {
					reversed = true;
					k = length-k;
				}else {
					reversed = false;
				}
			}
			else {
				if(k<=length/2) {
					reversed = true;
				}else {
					reversed = false;
					k = length-k;
				}
			}

		}
	}
	public static void main(String[] args) {
		int[][] testData = {
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27},
				{1,2,3,4,5,6,7},

		};
		int[] test = {35,35};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			solution.rotate(testData[i], test[i]);
			System.out.println(Arrays.toString(testData[i]));
		}
	}
}
