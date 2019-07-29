package leetCode.problems._198_House_Robber;

public class Solution {
    public int rob(int[] nums) {
        int[] result = new int[3];
        int i = nums.length-1;
        for (; i > -1; i--) {
			result[i%3]=nums[i]+Math.
					max(result[(i+2)%3], result[(i)%3]);	
		}
        return Math.max(result[0], result[1]);
    }
    public static void main(String[] args) {
		int[][] testData = {
				{2,7,9,3,1},
				{1,2,3,1},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(solution.rob(testData[i]));
		}
	}
}
