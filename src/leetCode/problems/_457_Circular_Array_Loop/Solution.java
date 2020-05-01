package leetCode.problems._457_Circular_Array_Loop;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        Integer[] loopFC = new Integer[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
			if(nums[i]>0) {
				if(i+nums[i]>=nums.length) {
					loopFC[i] = (i+nums[i])%nums.length;
					if(loopFC[i]==i)
						loopFC[i]=null;
				}else {
					int ni = i+nums[i];
					if(loopFC[ni]!=null) {
						loopFC[i] = loopFC[ni];
						if(loopFC[i]==i)
							return true;
						else {
							Integer newLi = loopFC[i];
							HashSet<Integer> uniques = new HashSet<>();
							uniques.add(i);
							while (newLi!=null) {
								if(!uniques.add(newLi))
									return true;
								newLi = loopFC[newLi];
							}
						}
					}	
				}
			}	
		}
        Arrays.fill(loopFC, null);
        for (int i = 0; i < loopFC.length; i++) {
			if(nums[i]<0) {
				if(i+nums[i]<0) {
					loopFC[i] = nums.length+(i+nums[i])%nums.length;
					if(loopFC[i]==i)
						loopFC[i]=null;
				}else {
					int ni = i+nums[i];
					if(loopFC[ni]!=null) {
						loopFC[i] = loopFC[ni];
						if(loopFC[i]==i)
							return true;
						else {
							Integer newLi = loopFC[i];
							HashSet<Integer> uniques = new HashSet<>();
							uniques.add(i);
							while (newLi!=null) {
								if(!uniques.add(newLi))
									return true;
								newLi = loopFC[newLi];
							}
						}
					}
				}
			}
		}
        return false;
    }
}
