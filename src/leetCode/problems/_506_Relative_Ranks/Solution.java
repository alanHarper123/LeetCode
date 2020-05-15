package leetCode.problems._506_Relative_Ranks;

import java.util.Random;

public class Solution {
	private static String[] awardRanks = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] nums) {

    	int[] indexs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
			indexs[i] = i;
		}
        quickSort(nums, 0, nums.length, indexs);
        String[] relativeRanks = new String[nums.length];
        for (int i = 0; i<awardRanks.length&&i<nums.length; i++) {
        	relativeRanks[indexs[i]] = awardRanks[i];
		}
        for (int i = 3; i<relativeRanks.length; i++) {
        	relativeRanks[indexs[i]] = String.valueOf(i+1);
		}
        return relativeRanks;
    }
    Random rand = new Random(System.currentTimeMillis());
    private void quickSort(int[] nums,int start,int end,int[] indexs) {
    	if(end<=start+1)
    		return;
    	int pivot = nums[start+rand.nextInt(end-start)];
    	int i = start;
    	for (int j = start; j < end; j++) {
			if(nums[j]>pivot) {
				int temp = nums[i];
				int tempi = indexs[i];
				indexs[i] = indexs[j];
				nums[i++] = nums[j];
				nums[j] = temp;
				indexs[j] = tempi;
			}
		}
    	quickSort(nums, start, i, indexs);
    	quickSort(nums, i, end, indexs);
    }
}
