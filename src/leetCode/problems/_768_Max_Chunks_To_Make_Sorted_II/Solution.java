package leetCode.problems._768_Max_Chunks_To_Make_Sorted_II;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[][] valToIndex = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
			valToIndex[i][0] = arr[i];
			valToIndex[i][1] = i;
		}
        Arrays.sort(valToIndex, (ar1,ar2)->ar1[0]-ar2[0]);
        Integer preEnd = null;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
			int end = Math.max(i, valToIndex[i][1]);
			int start = Math.min(i, valToIndex[i][1]);
			if(preEnd==null) {
				preEnd = end;
			}else {
				if(start<=preEnd) {
					preEnd = Math.max(preEnd, end);
				}else {
					count++;
					preEnd = end;
				}
			}
		}
        if(preEnd!=null)
        	count++;
        return count;
    }
    public int maxChunksToSorted002(int[] arr) {
        
        LinkedList<Integer> intervals = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
			int num = arr[i];
			if(intervals.isEmpty()||intervals.peekLast()<=num) {
				intervals.add(num);
			}else{
				int end = intervals.pollLast();
				while (!intervals.isEmpty()&&intervals.peekLast()>num) {
					intervals.pollLast();
				}
				intervals.add(end);
			}
		}
        return intervals.size();
    }
}
/*
768. Max Chunks To Make Sorted II
Hard

This question is the same as "Max Chunks to Make Sorted" except the integers of the given array are not necessarily distinct, the input array could be up to length 2000, and the elements could be up to 10**8.

Given an array arr of integers (not necessarily distinct), we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [5,4,3,2,1]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.

Example 2:

Input: arr = [2,1,3,4,4]
Output: 4
Explanation:
We can split into two chunks, such as [2, 1], [3, 4, 4].
However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.

Note:

    arr will have length in range [1, 2000].
    arr[i] will be an integer in range [0, 10**8].

 */
