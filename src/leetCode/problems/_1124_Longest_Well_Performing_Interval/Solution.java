package leetCode.problems._1124_Longest_Well_Performing_Interval;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    public int longestWPI(int[] hours) {
        LinkedList<Integer> sequences = new LinkedList<>();
        int sum = 0;
        sequences.add(-1);
        sequences.add(sum);
        
        int maxLen = 0,preIndex=0;
        
        for (int i = 0; i < hours.length; i++) {
			if(hours[i]>8) {
				sum++;
			}else 
				sum--;
			if(sequences.peekLast()>sum) {
				sequences.add(i);
				sequences.add(sum);
			}else if(sequences.peekLast()<sum){
				ListIterator<Integer> iter = sequences.listIterator(sequences.size());
				while (iter.hasPrevious()&&iter.previous()<sum) {
					preIndex = iter.previous();
				}
				if(maxLen<i-preIndex)
					maxLen = i-preIndex;
			}
		}
        return maxLen;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().longestWPI(new int[] {9,9,6,0,6,6,9}));
	}
}
/*
1124. Longest Well-Performing Interval
Medium

We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.

 

Example 1:

Input: hours = [9,9,6,0,6,6,9]
Output: 3
Explanation: The longest well-performing interval is [9,9,6].

 

Constraints:

    1 <= hours.length <= 10000
    0 <= hours[i] <= 16

*/
