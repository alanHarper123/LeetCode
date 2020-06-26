package leetCode.problems._Find_the_Duplicate_Number;

public class Solution {
    public int findDuplicate(int[] nums) {
        int runner = nums[0];
        int fastRunner = nums[runner];
        while (runner!=fastRunner) {
			runner = nums[runner];
			fastRunner = nums[nums[fastRunner]];
		}
        int fRunner = nums[0];
        while (fRunner!=runner) {
        	fRunner = nums[fRunner];
        	runner = nums[runner];
		}
        return runner;
    }
}
