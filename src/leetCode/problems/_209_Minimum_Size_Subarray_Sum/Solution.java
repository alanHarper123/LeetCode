package leetCode.problems._209_Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
    	int minCount = Integer.MAX_VALUE;
        int count = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
			sum += nums[j];

			while (sum-nums[j-count]>=s) {
				sum -= nums[j-count];
				count--;
			}
			count++;
			if(sum>=s&&minCount>count)
				minCount = count;
		}
        return minCount==Integer.MAX_VALUE?0:minCount;
    }
    public static void main(String[] args) {
    	int[] testData1 = 
				{11};
		int[][] testData2 = {
				{1,2,3,4,5},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testData2.length; i++) {
			System.out.println(
					solution.minSubArrayLen(
							testData1[i], testData2[i]));
		}
	}
}
