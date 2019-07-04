package leetCode.problems._55_Jump_Game;

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] indicator = new boolean[nums.length];
        backTrack(indicator, nums, 0);
        return indicator[nums.length-1];
    }
    private void backTrack(boolean[] indicator,int[] nums, int start) {
    		indicator[start]=true;
    		if(indicator[nums.length-1]) {
				return;
			}
    	for (int i = Math.min(nums[start], nums.length-1-start); i > 0&&i+start<nums.length; i--) {
    		
    		if(indicator[i+start]==true)
    			continue;
			backTrack(indicator, nums, i+start);
		}
    }
    public static void main(String[] args) {
		int[] test1 = {2,3,1,1,4};
		int[] test2 = {3,2,1,0,4};
		int[] test3 = {3,0,8,2,0,0,1};
		Solution solution = new Solution();
		System.out.println(solution.canJump(test1));
		System.out.println(solution.canJump(test2));
		System.out.println(solution.canJump(test3));
	}
}
