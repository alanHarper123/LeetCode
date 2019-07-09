package leetCode.problems._75_Sort_Colors;

public class Solution {
    public void sortColors(int[] nums) {
        int zeroIndex = 0;
        int twoIndex = nums.length-1;
        for (int i = 0; i < nums.length&&i<=twoIndex; i++) {
			if(nums[i]==0) {
				if(zeroIndex!=i) {
					nums[zeroIndex]=0;
					nums[i]=1;
				}
				zeroIndex++;	
			}else if (nums[i]==2) {
				nums[i] = nums[twoIndex];
				nums[twoIndex]=2;
				twoIndex--;
				i--;
			}	
		}
    }
}
