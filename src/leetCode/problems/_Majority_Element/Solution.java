package leetCode.problems._Majority_Element;

public class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer num = null;
        for (int i = 0; i < nums.length; i++) {
			if(num==null) {
				num = nums[i];
				count = 1;
			}else if(num==nums[i]) {
				count++;
			}else {
				count--;
				if(count==0)
					num = null;
			}
		}
        return num;
    }
}
