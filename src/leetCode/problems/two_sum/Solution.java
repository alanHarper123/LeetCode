package leetCode.problems.two_sum;

import java.util.Arrays;
import java.util.Comparator;


class ArrayComparator implements Comparator<Integer[]>{
	@Override
	public int compare(Integer[] o1, Integer[] o2) {
		
		return o1[0]-o2[0];
	}
}


public class Solution {
    public int[] twoSum(int[] nums, int target) {
    	Integer[][] index = new Integer[nums.length][2];
    	for(int k = 0; k<nums.length; k++) {
    		Integer[] temp = {nums[k],k};
    		index[k] = temp;
    		
    	}
    	ArrayComparator arrayComparator = new ArrayComparator();
        Arrays.sort(index,arrayComparator);
        int[] result = new int[2];
        for(int i = 0; i<index.length;i++) {
        	int temp = target - index[i][0];

        	for(int j=i+1; j<index.length; j++) {
        		if(temp == index[j][0]) {
        			result[0] = index[i][1];
        			result[1] = index[j][1];
        			return result;
        		}
        		if(temp < index[j][0]) {
        			break;
        		}
        	}
        }
        return result;
    }
}
