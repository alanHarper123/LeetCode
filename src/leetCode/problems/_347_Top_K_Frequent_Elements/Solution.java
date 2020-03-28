package leetCode.problems._347_Top_K_Frequent_Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class Solution {
	private HashMap<Integer, Integer> base;
	private ArrayList<Entry<Integer,Integer>> dCount;
	private Random random = new Random();
    public List<Integer> topKFrequent(int[] nums, int k) {
        base = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
        	Integer count = base.get(nums[i]);
        	if(count==null)
        		count = 0;
        	base.put(nums[i], count+1);	
		}
        dCount = new ArrayList<>(base.entrySet());
        PartialQuickSort(dCount, 0, dCount.size(), k);
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
			result.add(dCount.get(i).getKey());
		}
        return result;
    }
    private void PartialQuickSort(ArrayList<Entry<Integer,Integer>> dCount
    		,int start, int end,int k) {
    	Entry<Integer,Integer> pivot = dCount.get(start+random.nextInt(end-start));
    	int i=start;
    	for (int right=end-1; i <= right;) {
			if(dCount.get(i).getValue()>=pivot.getValue()) {
				i++;
			}else {
				Entry<Integer,Integer> temp = dCount.get(right);
				dCount.set(right, dCount.get(i));
				dCount.set(i, temp);
				right--;
			}
		}
    	if(i-start==k)
    		return;
    	else if(i<k){
			PartialQuickSort(dCount, i, end, k-i+start);
		}else {
			PartialQuickSort(dCount, start, i, k);
		}		
    }
}
