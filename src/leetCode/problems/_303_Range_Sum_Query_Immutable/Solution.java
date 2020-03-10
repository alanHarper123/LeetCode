package leetCode.problems._303_Range_Sum_Query_Immutable;

class NumArray {
	static int[] sumRanges;
	public NumArray(int[] nums) {
		sumRanges = new int[nums.length+1];

		for (int j = 1; j < nums.length+1; j++) {
			sumRanges[j]=sumRanges[j-1]+nums[j-1];
		}

	}

	public int sumRange(int i, int j) {
		return sumRanges[j+1]-sumRanges[i];
	}
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
