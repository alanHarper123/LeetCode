package leetCode.problems._448_Find_All_Numbers_Disappeared_in_an_Array;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	LinkedList<Integer> absences = new LinkedList<>();
    	if(nums==null)
    		return absences;
        for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i])-1;
			if(nums[index]>0) {
				nums[index]=-nums[index];
			}
		}
        for (int i = 0; i < nums.length; i++) {
			if(nums[i]>0)
				absences.add(i+1);
		}
        return absences;
        
    }
}
