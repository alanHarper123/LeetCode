package leetCode.problems._628_Maximum_Product_of_Three_Numbers;

public class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = max1;
        int max3 = max1;
        int min1 = Integer.MAX_VALUE;
        int min2 = min1;
        for (int num:nums) {
			if(num>max1) {
				max3 = max2;
				max2 = max1;
				max1 = num;
			}else if (num>max2) {
				max3 = max2;
				max2 = num;
			}else if (num>max3) {
				max3 = num;
			}
			if(num<min1) {
				min2 = min1;
				min1 = num;
			}else if (num<min2) {
				min2 = num;
			}
		}
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
}
