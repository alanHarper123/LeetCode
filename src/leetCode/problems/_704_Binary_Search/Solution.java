package leetCode.problems._704_Binary_Search;

public class Solution {
    public int search(int[] nums, int target) {
        if(nums==null||nums.length==0)
        	return -1;
        int start = 0, end = nums.length;
        while (start!=end) {
        	int mid = (start+end)/2;
        	if(nums[mid]<target) {
        		start=mid+1;
        	}else if(nums[mid]>target) {
        		end = mid;
        	}else {
        		return mid;
        	}
		}
        return -1;
    }
}
