package leetCode.problems._565_Array_Nesting;


public class Solution {
    public int arrayNesting(int[] nums) {
    	int maxL = 0;
        boolean[] isVisited = new boolean[nums.length];
        for (int i = 0; i < nums.length&&maxL<nums.length-i; i++) {
			if(isVisited[i]==false) {
				int j = i;
				int li=0;
				do {
					li++;
					isVisited[j] = true;
					j = nums[j];
				} while (isVisited[j]==false);
				if(maxL<li)
					maxL = li;
			}
		}
        return maxL;
    }
}
