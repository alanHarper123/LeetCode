package leetCode.problems._90_Subsets_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTrack(nums,result,new boolean[nums.length],new ArrayList<>(),0);
        return result;
    }
    private void backTrack(int[] nums,List<List<Integer>>result,
    		boolean[] used,List<Integer> list, int start) {
		if(start==nums.length)
			return;
		for (int i = start; i < nums.length; i++) {
			if(i>0&&nums[i]==nums[i-1]&&used[i-1]==false)
				continue;
			list.add(nums[i]);
			used[i]=true;
			result.add(new ArrayList<>(list));
			backTrack(nums, result,used, list, i+1);
			list.remove(list.size()-1);
			used[i]=false;
		}
    }
	public static void main(String[] args) {
		int[][]test = {
				{1,2,2},
				{1,2,2,2,3,4},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[] js = test[i];
			System.out.println(solution.subsetsWithDup(js));
		}
	}
}
