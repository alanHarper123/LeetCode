package leetCode.problems._338_Counting_Bits;

public class Solution {
	public int[] countBits(int num) {
		boolean[] isBitSet = new boolean[8*Integer.BYTES];
		int[] bitCounts = new int[num+1];
		int i;
		for (int j = 1; j <= num; j++) {
			for (i=0; i < isBitSet.length; i++) {

				isBitSet[i]=!isBitSet[i];
				if(isBitSet[i]) 
					break;
			}
			bitCounts[j]=bitCounts[j-1]+1-i;
		}
		return bitCounts;
	}
}