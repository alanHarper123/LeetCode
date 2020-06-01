package leetCode.problems._599_Minimum_Index_Sum_of_Two_Lists;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> canteenToIndex = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
			canteenToIndex.put(list1[i], i);
		}
        int min = Integer.MAX_VALUE;
        LinkedList<String> canteens = new LinkedList<>();
        for (int i = 0; i < list2.length&&i<=min; i++) {
			Integer j = canteenToIndex.get(list2[i]);
			if(j!=null) {
				if(i+j<min) {
					canteens.clear();
					canteens.add(list2[i]);
					min = i+j;
				}else if(i+j==min) {
					canteens.add(list2[i]);
				}
			}
		}

        return canteens.toArray(new String[0]);
    }
}
