package leetCode.problems._88_Merge_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        while (j>=0&&i>=0) {
			if (nums1[i]<=nums2[j]) 
				nums1[k--]=nums2[j--];
			else 
				nums1[k--]=nums1[i--];
		}
        while (j>=0) {
			nums1[k--] =nums2[j--];
			
		}
    }
    public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0};
		int[] nums2 = {2,5,6};
		Solution solution = new Solution();
		solution.merge(nums1, 3, nums2, 3);
		System.out.println(Arrays.toString(nums1));
	}
}
