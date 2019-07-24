package leetCode.problems._153_Find_Minimum_in_Rotated_Sorted_Array;


class Solution {
    public int findMin(int[] nums) {
        if(nums.length==0)
        	return -1;
        if(nums.length==1)
        	return nums[0];
        int i=0;
        int k=1;
        while (true) {
        	k=1;
			while (i+k<nums.length&&nums[i+k]>nums[i]) {
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
				{3,4,5,1,2},
				{4,5,6,7,0,1,2},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testsData.length; i++) {
			System.out.println(solution.findMin(testsData[i]));
		}
	}
}
