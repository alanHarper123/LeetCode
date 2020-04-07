package leetCode.problems._Counting_Elements;

import java.util.HashSet;

public class Solution {

	public int countElements(int[] arr) {
		HashSet<Integer> base = new HashSet<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			base.add(arr[i]);
		}
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(base.contains(arr[i]+1))
				count++;
		}
		return count;
	}

}
