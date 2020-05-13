package leetCode.problems._496_Next_Greater_Element_I;

import java.util.HashMap;

public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nextGreaters = new int[nums1.length];
        HashMap<Integer,Integer> nums1Map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
        	nums1Map.put(nums1[i], i);
		}
        for (int i = nums2.length-1; i >=0; i--) {
			while (i>=0&&!nums1Map.containsKey(nums2[i])) {
				i--;
			}
			if(i>=0) {
				int j = i+1;
				for (; j < nums2.length; j++) {
					if(nums2[j]>nums2[i]) {
						nextGreaters[nums1Map.get(nums2[i])] = nums2[j];
						break;
					}
				}
				if(j==nums2.length)
					nextGreaters[nums1Map.get(nums2[i])] = -1;
			}
		}

        return nextGreaters;
    }

}
