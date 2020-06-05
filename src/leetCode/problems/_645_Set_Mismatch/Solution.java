package leetCode.problems._645_Set_Mismatch;

public class Solution {
    public int[] findErrorNums(int[] nums) {
    	int dupNum=0;
    	int missingNum=0;
        boolean[] isNumExited = new boolean[nums.length+1];
        for (int num:nums) {
			if(isNumExited[num])
				dupNum = num;
			isNumExited[num]=true;
		}
        for (int i = 1; i < isNumExited.length; i++) {
			if(isNumExited[i]==false) {
				missingNum = i;
				break;
			}
		}
        return new int[] {dupNum,missingNum};
    }
}
