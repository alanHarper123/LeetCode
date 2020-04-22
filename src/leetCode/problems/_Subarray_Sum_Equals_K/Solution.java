package leetCode.problems._Subarray_Sum_Equals_K;

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumCounts = new HashMap<>();
        int sum = 0;
        int count = 0;
        sumCounts.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
			Integer iCount = sumCounts.get(sum-k);
			if(iCount!=null)
				count+=iCount;
            Integer sumCount = sumCounts.get(sum);
			if(sumCount==null)
				sumCount=0;
			sumCounts.put(sum, sumCount+1);
		}
        return count;
    }
}
