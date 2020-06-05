package leetCode.problems._646_Maximum_Length_of_Pair_Chain;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, (p1,p2)->{
			if(p1[0]==p2[0])
				return p1[1]-p2[1];
			return p1[0]-p2[0];
		});
		ArrayList<int[]> base = new ArrayList<>(pairs.length);
		base.add(pairs[0]);
		for (int i = 1; i < pairs.length; i++) {
			int[] pair = pairs[i];
			for (int j = 0; j < base.size(); j++) {
				if(pair[0]>base.get(j)[1]) {
					if(j==base.size()-1) {
						base.add(pair);
						break;
					}
				}else if(pair[1]<base.get(j)[1]){
					base.set(j, pair);
					break;
				}
			}
		}
		return base.size();
	}
}
