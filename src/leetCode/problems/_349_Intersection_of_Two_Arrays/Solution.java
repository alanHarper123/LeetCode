package leetCode.problems._349_Intersection_of_Two_Arrays;

import java.util.HashSet;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> base = new HashSet<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
			base.add(nums1[i]);
		}
        HashSet<Integer> base2 = new HashSet<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
			if(base.contains(nums2[i]))
					base2.add(nums2[i]);
		}
        int[] result = new int[base2.size()];
        int i=0;
        for(Integer in : base2)
        	result[i++]=in;
        return result;
    }
}
