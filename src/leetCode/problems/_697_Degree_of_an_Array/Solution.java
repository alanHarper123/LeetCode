package leetCode.problems._697_Degree_of_an_Array;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    public int findShortestSubArray(int[] nums) {
        ArrayList<Integer> frs = new ArrayList<>(nums.length);
        ArrayList<Integer> numStarts = new ArrayList<>(nums.length);
        ArrayList<Integer> lengths = new ArrayList<>(nums.length);
        HashMap<Integer, Integer> numToIndex = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			Integer index = numToIndex.get(num);
			if(index==null){
				index = frs.size();
				frs.add(0);
				numStarts.add(i);
				numToIndex.put(num, index);
				lengths.add(0);
			}
			frs.set(index, frs.get(index)+1);
			lengths.set(index, i-numStarts.get(index)+1);
		}
        int maxFr=0;
        int minL=0;
        for (int i = 0; i < frs.size(); i++) {
        	int fr = frs.get(i);
			if(fr>maxFr) {
				maxFr = fr;
				minL = lengths.get(i);
			}else if(fr==maxFr) {
				if(minL>lengths.get(i))
					minL = lengths.get(i);
			}
		}
        return minL;
    }
}
