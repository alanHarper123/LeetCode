package leetCode.problems._46_Permutations;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		
		int[] indexes = new int[nums.length+1];
		indexes[0]=1;
		indexes[1]=1;
		for (int i = 2; i < indexes.length; i++) {
			indexes[i]=indexes[i-1]*i;
		}
		List<List<Integer>> resultTempList = new ArrayList<List<Integer>>(
				indexes[indexes.length-1]);
		for (int i = 0; i < indexes[indexes.length-1]; i++) {
			resultTempList.add(new LinkedList<Integer>());
		}
		boolean [][] isEleTaken = new boolean[indexes[indexes.length-1]][nums.length];

		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			int step = 0;
			for (int j = 0; j < resultTempList.size(); j++,count++) {

				if(count==indexes[nums.length-i-1]) {
					step++;
					if(step+i==nums.length) {
						step = -i;
					}
					count=0;
				}
				for (int k = step+i; k < isEleTaken[j].length+step+i; k++) {
					int index = k>=nums.length?k%nums.length:k;
					if (!isEleTaken[j][index]) {
						resultTempList.get(j).add(nums[index]);
						isEleTaken[j][index]=true;
						step = k-i;
						if(step+i>=nums.length) {
							step -= nums.length;
						}
						break;
					}
				}

			}
		}
		return resultTempList;
	}
	public static void main(String[] args) {
		int[] test = {1,2,3,4,5};
		System.out.println(new Solution().permute(test));
	}
}
