package leetCode.problems._1186_Maximum_Subarray_Sum_with_One_Deletion;

public class Solution {
	public int maximumSum(int[] arr) {
		int maxSum = Integer.MIN_VALUE;
		for(int e:arr) {
			if(e>maxSum)
				maxSum = e;
		}
		int[] leftSum = new int[arr.length+1];
		for (int i = 0; i < arr.length; i++) {
			leftSum[i+1] = arr[i]+leftSum[i];
		}
		int min = Integer.MAX_VALUE;
		int[] leftMins = new int[arr.length+1];
		for (int i = 0; i < leftSum.length; i++) {
			if(leftSum[i]<min)
				min = leftSum[i];
			leftMins[i] = min;
			if(i!=0&&leftSum[i]-leftMins[i-1]>maxSum)
				maxSum = leftSum[i]-leftMins[i-1];
		}
		int[] rightSum = new int[arr.length+1];
		for (int i = arr.length-1; i >=0; i--) {
			rightSum[i] = rightSum[i+1]+arr[i];
		}
		int[] rightMins = new int[arr.length+1];
		min = Integer.MAX_VALUE;
		for (int i = arr.length; i >=0; i--) {
			if(rightSum[i]<min)
				min = rightSum[i];
			rightMins[i] = min;
		}
		for (int i = 1; i < arr.length-1; i++) {
			int sum = leftSum[i]-leftMins[i-1]+rightSum[i+1]-rightMins[i+2]; 
			if(sum>maxSum)
				maxSum = sum;
		}
		return maxSum;
	}
	public static void main(String[] args) {
		System.out.println(new Solution().maximumSum(new int[] {-1,-1,-1,-1
}));
	}
}
/*
1186. Maximum Subarray Sum with One Deletion
Medium

Given an array of integers, return the maximum sum for a non-empty subarray (contiguous elements) with at most one element deletion. In other words, you want to choose a subarray and optionally delete one element from it so that there is still at least one element left and the sum of the remaining elements is maximum possible.

Note that the subarray needs to be non-empty after deleting one element.

 

Example 1:

Input: arr = [1,-2,0,3]
Output: 4
Explanation: Because we can choose [1, -2, 0, 3] and drop -2, thus the subarray [1, 0, 3] becomes the maximum value.

Example 2:

Input: arr = [1,-2,-2,3]
Output: 3
Explanation: We just choose [3] and it's the maximum sum.

Example 3:

Input: arr = [-1,-1,-1,-1]
Output: -1
Explanation: The final subarray needs to be non-empty. You can't choose [-1] and delete -1 from it, then get an empty subarray to make the sum equals to 0.

 

Constraints:

    1 <= arr.length <= 10^5
    -10^4 <= arr[i] <= 10^4
*/