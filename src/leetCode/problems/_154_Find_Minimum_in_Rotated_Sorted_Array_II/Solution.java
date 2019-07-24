package leetCode.problems._154_Find_Minimum_in_Rotated_Sorted_Array_II;

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0)
        	return -1;
        if(nums.length==1)
        	return nums[0];
        int i=0;
        int k=1;
        if(nums[0]<nums[nums.length-1]) {
        	return nums[0];
        }else if (nums[0]==nums[nums.length-1]) {
        	int j;
			for (j = 1; j < nums.length; j++) {
				if(nums[j]>nums[j-1]) {
					i=j;
					break;
				}else if (nums[j]<nums[j-1]) {
					return nums[j];
				}
			}
			if(j==nums.length)
				return nums[0];
		}
        while (true) {
        	k=1;
			while (i+k<nums.length&&nums[i+k]>=nums[i]) {
				i+=k;
				k=k<<1;
			}
			if(k==1){
				if(i+k>=nums.length)
					return nums[0];
				else 
					return nums[i+1];	
			}
		}
    }
    public static void main(String[] args) {
    	int[][] testsData = {
				{1,3,5},
				{2,2,2,0,1},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testsData.length; i++) {
			System.out.println(solution.findMin(testsData[i]));
		}
	}
}
