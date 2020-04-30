package leetCode.problems._451_Sort_Characters_By_Frequency;

import java.util.Arrays;

public class Solution {
	public String frequencySort(String s) {
		int[][] fr = new int[128][2];
		for (int i = 0; i < fr.length; i++) {
			fr[i] = new int[] {i,0};
		}
		for (int i = 0; i < s.length(); i++) {
			fr[s.charAt(i)][1]++;
		}
		Arrays.sort(fr,(ar1,ar2)->ar1[1]-ar2[1]);
		int fri = fr.length-1;
		StringBuilder stringBuilder = new StringBuilder();
		while (fri>=0) {

			int c = fr[fri][1];
			while (c>0) {
				stringBuilder.append((char) (fr[fri][0]));
				c--;
			}
			fri--;

		}
		return stringBuilder.toString();
	}
}
