package leetCode.problems._553_Optimal_Division;

public class Solution {
    public String optimalDivision(int[] nums) {
    	if(nums.length==1)
    		return String.valueOf(nums[0]);
    	if(nums.length==2)
    		return String.valueOf(nums[0])+"/"+String.valueOf(nums[1]);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nums[0]);
        stringBuilder.append('/');
        stringBuilder.append('(');
        for (int i = 1; i < nums.length; i++) {
        	stringBuilder.append(nums[i]);
			stringBuilder.append('/');
		}
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        stringBuilder.append(')');
        
        return stringBuilder.toString();
    }
}
