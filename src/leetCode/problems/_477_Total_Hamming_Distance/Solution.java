package leetCode.problems._477_Total_Hamming_Distance;

public class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] totalbits = new int[8*Integer.BYTES];
        int sum = 0;
        int totalSum = 0;
        for (int num:nums) {
			for (int i = 0; num!=0; i++) {
				if((num&2)==1) {
					totalbits[i]++;
					totalSum++;
				}
				num>>>=1;
			}
		}
        for (int i = 0; i < nums.length-1; i++) {
			int num = nums[i];
			int sumi = totalSum;
			for (int j = 0; num!=0; j++) {
				if((num&2)==1) {
					sumi -= 2*totalbits[j]-nums.length+i;
					totalbits[j]--;
					totalSum--;
				}
				num>>>=1;
			}
			sum+=sumi;
		}

        return sum;
    }
}
