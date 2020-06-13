package leetCode.problems._Largest_Divisible_Subset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	public List<Integer> largestDivisibleSubset(int[] nums) {
		LinkedList<Integer> lDSubset = new LinkedList<>();
		if(nums==null||nums.length==0)
			return lDSubset;
		Arrays.sort(nums);
		int maxL = 1;
		int maxIndex = 0;
		int[] maxIndexs = new int[nums.length];
		int[] maxLs = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			int l = 1;
			int index = -1;
			for (int j = i-1; j >=0 ; j--) {
				if(maxLs[j]+1>l&&nums[i]%nums[j]==0) {
					l = maxLs[j]+1;
					index = j;
				}
			}
			maxIndexs[i] = index;
			maxLs[i] = l;
			if(l>maxL) {
				maxL = l;
				maxIndex = i;
			}	
		}
		while (maxIndex!=-1) {
			lDSubset.addFirst(nums[maxIndex]);
			maxIndex = maxIndexs[maxIndex];
		}
		return lDSubset;
	}
}
