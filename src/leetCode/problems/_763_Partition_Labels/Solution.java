package leetCode.problems._763_Partition_Labels;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        int[][] charToIntervals = new int[26][];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
			int index = chars[i] - 'a';
			int[] interval = charToIntervals[index];
			if(interval==null) {
				interval = new int[] {i,i};
				charToIntervals[index] = interval;
			}else {
				interval[1] = i;
			}
		}
        Arrays.sort(charToIntervals,(in1,in2)->{
        	if(in1!=null&&in2!=null)
        		return in1[0]-in2[0];
        	if(in1!=null)
        		return 1;
        	else {
        		return -1;
        	}
        });
        int i = 0;
        while (i<charToIntervals.length&&charToIntervals[i]==null) {
        	i++;
		}
        List<Integer> result = new LinkedList<>();
        int[] preInterval = null;
        for (; i < charToIntervals.length; i++) {
			int[] cur = charToIntervals[i];
			if(preInterval==null) {
				preInterval = cur;
			}else {
				if(cur[0]>preInterval[1]) {
					result.add(preInterval[1]-preInterval[0]+1);
					preInterval = cur;
				}else 
					preInterval[1] = Math.max(cur[1], preInterval[1]);
			}
		}
        if(preInterval!=null) {
        	result.add(preInterval[1]-preInterval[0]+1);
        }
        return result;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.partitionLabels("ababcbacadefegdehijhklij"));
	}
}
/*
 763. Partition Labels
Medium

A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 

Note:

    S will have length in range [1, 500].
    S will consist of lowercase English letters ('a' to 'z') only.

 */
