package leetCode.problems._456_132_Pattern;

import java.util.LinkedList;

public class Solution {
	public boolean find132pattern(int[] nums) {
		if(nums==null||nums.length<3)
			return false;
		LinkedList<int[]> oneThrees = new LinkedList<>();
		for (int i = 0; i < nums.length;) {
			int one = nums[i++];
			if(i>=nums.length)
				return false;
			if(nums[i]<=nums[i-1]) {
				while (i<nums.length&&nums[i]<=nums[i-1]) {
					i++;
				}
				if(i>=nums.length)
					return false;
				one = nums[i-1];
			}
			while (i<nums.length&&nums[i]>=nums[i-1]) {
				int[] oneThree = oneThrees.peekLast();
				while(oneThree!=null) {
					if(oneThree[0]<nums[i]&&nums[i]<oneThree[1]) {
						return true;
					}else if(nums[i]>=oneThree[1]) {
						oneThrees.pollLast();
						oneThree = oneThrees.peekLast();
					}else
						oneThree = null;
				}
				i++;
			}
			if(i>=nums.length)
				return false;
			int three = nums[i-1];
			if(nums[i]>one)
				return true;
			int[] newOneThree = new int[] {one,three};
			oneThrees.add(newOneThree);
		}
		return false;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = new int[]{-2,1,1};
		System.out.println(solution.find132pattern(test));
	}
}
