package leetCode.problems._384_shuffle_array;

import java.util.Random;

public class Solution {
	private int[] nums;
	private Random rand = new Random(System.currentTimeMillis());
    public Solution(int[] nums) {
    	this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
    	return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	int[] newOrder = new int[nums.length];
    	for (int i = 1; i < newOrder.length; i++) {
			newOrder[i] = i;
		}
    	for (int i = newOrder.length; i > 0; i--) {
			int r = rand.nextInt(i);
			int temp = newOrder[i-1];
			newOrder[i-1] = nums[newOrder[r]];
			if(r!=i-1)
				newOrder[r] = temp;
		}
    	return newOrder;
    }
    public static void main(String[] args) {
		int[] test = new int[] {1,2,3};
		System.out.println(new Solution(test).shuffle());
	}
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
