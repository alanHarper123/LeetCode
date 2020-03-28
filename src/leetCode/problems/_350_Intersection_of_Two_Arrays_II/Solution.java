package leetCode.problems._350_Intersection_of_Two_Arrays_II;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	HashMap<Integer, Integer> base;
    public int[] intersect(int[] nums1, int[] nums2) {
        base = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
			Integer temp = base.get(nums1[i]);
			if(temp==null)
				temp=0;
			base.put(nums1[i], temp+1);
		}
        int[] result = new int[base.size()];
        int count = 0;
        for (int j = 0; j < result.length; j++) {
			Integer temp = base.get(nums2[j]);
			if(temp!=null) {
				temp--;
				if(temp==0)
					temp=null;
				base.put(nums2[j], temp);
				result[count++] = nums2[j];
			}	
		}
        return Arrays.copyOfRange(result, 0, count);
    }
}
