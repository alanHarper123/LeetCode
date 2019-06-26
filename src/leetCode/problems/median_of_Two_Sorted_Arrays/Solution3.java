package leetCode.problems.median_of_Two_Sorted_Arrays;

public class Solution3 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	if(n<m) {
    		return findMedianSortedArrays(nums2, nums1);
    	}
    	
    	int iMin = 0, iMax = m, halfLenth = (m+n+1)/2;
    	int i = 0, j = 0;
    
    	
    	for(;;) {
			i = (iMax+iMin)/2;
			j = halfLenth-i;
			if((i!=0&&nums1[i-1]>nums2[j])) {
				if(iMax!=i) iMax=i;
				else iMax--;
			}else if((i!=m&&nums1[i]<nums2[j-1])){
				if(iMin != i) iMin = i;
				else iMin++;

			}else {
				double result = 0.0;
				result = Math.max(i==0?Integer.MIN_VALUE:nums1[i-1], j==0?Integer.MIN_VALUE:nums2[j-1]);
				if((m+n)%2==0) {
					result+= Math.min(i==m?Integer.MAX_VALUE:nums1[i], j==n?Integer.MAX_VALUE:nums2[j]);
					result /= 2;
				}
				return result;
			}
			
		}

    }

}
