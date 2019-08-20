package leetCode.problems._213_House_Robber_II;


public class Solution {
	public int rob(int[] nums) {
		if(nums.length==1)
			return nums[0];
		return Math.max(robUtil(nums, 1, nums.length-1), robUtil(nums, 0, nums.length-2));
	}
    public int robUtil(int[] nums,int start,int end) {
        int[] result = new int[3];
        int i = end;
        for (; i >= start; i--) {
			result[i%3]=nums[i]+Math.
					max(result[(i+2)%3], result[(i)%3]);	
		}
        return Math.max(result[start], result[start+1]);
    }
	public static void main(String[] args) {
		int[][] testData = {
				{8,4,8,5,9,6,5,4,4,10},
				{1,2,3,1},
				{8,2,8,9,2},
				{2,7,9,3,1},
				{2,3,2},
				
		};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(solution.rob(testData[i]));
		}
	}
}
