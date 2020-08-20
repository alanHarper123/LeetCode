package leetCode.problems._954_Array_of_Doubled_Pairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution {
    public boolean canReorderDoubled(int[] A) {
        HashMap<Integer, Integer> counts = new HashMap<>(A.length);
        for(int i:A) {
        	counts.put(i, counts.getOrDefault(i, 0)+1);
        }
        ArrayList<Entry<Integer, Integer>> entrys = new ArrayList<>(counts.entrySet());
        Collections.sort(entrys,(e1,e2)->{
        	return Math.abs(e1.getKey())-Math.abs(e2.getKey());
        });
        for(Entry<Integer, Integer> entry:entrys) {
        	if(entry.getKey()==0) {
        		if((entry.getValue()&1)==1)
        			return false;
        	}else {
        		if(entry.getValue()!=0) {
        			Integer nV = counts.get(2*entry.getKey());
        			if(nV==null||(nV-=entry.getValue())<0)
        				return false;
        			counts.put(2*entry.getKey(), nV);
        		}
        		
        	}
        }
        return true;
    }
}
/*
954. Array of Doubled Pairs
Medium

Given an array of integers A with even length, return true if and only if it is possible to reorder it such that A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.

 

Example 1:

Input: [3,1,3,6]
Output: false

Example 2:

Input: [2,1,2,6]
Output: false

Example 3:

Input: [4,-2,2,-4]
Output: true
Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].

Example 4:

Input: [1,2,4,16,8,4]
Output: false

 

Note:

    0 <= A.length <= 30000
    A.length is even
    -100000 <= A[i] <= 100000
 */