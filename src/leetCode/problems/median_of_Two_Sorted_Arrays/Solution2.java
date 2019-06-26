package leetCode.problems.median_of_Two_Sorted_Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	ArrayList<Integer> resultArray = new ArrayList<>();
    	resultArray.ensureCapacity(nums1.length+nums2.length);
    	if(nums1.length>0) {
    		for(int i:nums1) {
    			resultArray.add(i);
    		}
    	}
    	if(nums2.length>0) {
    		for(int i:nums2) {
    			resultArray.add(i);
    		}
    	}
    	Collections.sort(resultArray);
    	double result = 0.0;
    	int a = (nums1.length+nums2.length)/2;
    	result+=resultArray.get(a);
    	if((nums1.length+nums2.length)%2==0) {
    		result+=resultArray.get(a-1);
    		result /= 2;
    	}
    	return result;
    	
    }

}
