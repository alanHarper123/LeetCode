package leetCode.problems._1200_Minimum_Absolute_Difference;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
			int dif = arr[i]-arr[i-1];
			if(dif<min)
				min = dif;
		}
        for (int i = 1; i < arr.length; i++) {
        	int dif = arr[i]-arr[i-1];
        	if(dif==min) {
        		LinkedList<Integer> ele = new LinkedList<>();
        		ele.add(arr[i-1]);
        		ele.add(arr[i]);
        		res.add(ele);
        	}
		}
        return res;
    }
}
