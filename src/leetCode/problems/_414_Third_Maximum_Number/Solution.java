package leetCode.problems._414_Third_Maximum_Number;

public class Solution {
    public int thirdMax(int[] nums) {
    	if(nums==null)
    		return 0;
        Integer max = null;
        Integer second = null;
        Integer third = null;
        for (int i = 0; i < nums.length; i++) {
			if(max==null)
				max = nums[i];
			else if(max>nums[i]){
				if(second==null)
					second = nums[i];
				else if(second>nums[i]) {
					if(third==null||third < nums[i])
						third = nums[i];
				}else if(second<nums[i]) {
					third = second;
					second = nums[i];
				}
			}else if(nums[i]>max) {
				third = second;
				second = max;
				max = nums[i];
			}		
		}
        return third==null?max:third;
    }
}
