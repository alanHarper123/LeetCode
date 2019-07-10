package leetCode.problems._78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        backTrack(nums,result,new ArrayList<>(),0);
        return result;
    }
    private void backTrack(int[] nums,List<List<Integer>>result,List<Integer> list, int start) {
		if(start==nums.length)
			return;
		for (int i = start; i < nums.length; i++) {
			list.add(nums[i]);
			result.add(new ArrayList<>(list));
			backTrack(nums, result, list, i+1);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		int[][]test = {
				{1,2,3},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[] js = test[i];
			System.out.println(solution.subsets(js));
		}
	}
}
