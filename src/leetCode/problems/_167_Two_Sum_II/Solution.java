package leetCode.problems._167_Two_Sum_II;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
    	int[] result = new int[2];
        if(numbers.length<2)
        	return result;
        int upperBound = numbers.length;
        int left;
        int k;
        for (int i = 0; i < upperBound; i++) {
			if(i>0&&numbers[i]==numbers[i-1])
				continue;
			left = target-numbers[i];
			while (true) {
				k=1;
				while (upperBound-k>i&&numbers[upperBound-k]>left) {
					upperBound-=k;
					k=k<<1;
				}
				if(k==1) {
					if(upperBound-k==i)
						return result;
					else if(numbers[upperBound-k]<left){
						break;
					}else {
						result[0]=i+1;
						result[1]=upperBound;
						return result;
					}
				}
			}
		}
        return result;
    }
    public static void main(String[] args) {
		int[][] testData = {
				{2,7,11,15},
		};
		int[] testData2 = {22,};
		Solution solution = new Solution();
		for (int i = 0; i < testData2.length; i++) {
			System.out.println(Arrays.toString(
					solution.twoSum(testData[i], testData2[i])));
		}
	}
}
