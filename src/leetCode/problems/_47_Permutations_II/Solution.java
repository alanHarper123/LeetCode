package leetCode.problems._47_Permutations_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Solution {
	ArrayList<List<Integer>> resultLists = new ArrayList<>();
	public List<List<Integer>> permuteUnique(int[] nums) {
		resultLists.clear();
		Arrays.sort(nums);
		backtrack(nums, new ArrayList<>(nums.length),new boolean[nums.length], new  ArrayList<>(nums.length),-1,-1);
		return resultLists;
	}
	private void backtrack(int[] nums, List<Integer> resultList,
			boolean[] indicator2,List<Integer>index,int lastRemove,int lastRemoveIndex) {
		
		for (int i = 0; i < nums.length; i++) {
			if(indicator2[i]==true||(lastRemove!=-1&&resultList.size()==lastRemoveIndex-1&&nums[lastRemove]==nums[i])) {
				continue;
			}
			resultList.add(nums[i]);
			indicator2[i]=true;
			index.add(i);
			if(resultList.size()==nums.length) {
				resultLists.add(new ArrayList<>(resultList));
			}else {
				backtrack(nums, resultList,indicator2,index,lastRemove,lastRemoveIndex);				
				lastRemove=index.get(index.size()-1);
			}
			lastRemoveIndex = index.size();
			resultList.remove(resultList.size()-1);
			indicator2[index.remove(index.size()-1)]=false;
		}
		
	}
	public static void main(String[] args) {
		int[] test = {1,1,1,2};
		System.out.println(new Solution().permuteUnique(test));
	}
}
