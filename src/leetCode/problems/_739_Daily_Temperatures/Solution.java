package leetCode.problems._739_Daily_Temperatures;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	public int[] dailyTemperatures(int[] T) {
		int[] result = new int[T.length];
		LinkedList<Integer> pres = new LinkedList<>();
		LinkedList<Integer> indexes = new LinkedList<>();
		for (int i = 0; i < result.length; i++) {
			while (!pres.isEmpty()&&pres.peekLast()<T[i]) {
				pres.pollLast();
				int index = indexes.pollLast();
				result[index] = i - index;
			} 
			pres.add(T[i]);
			indexes.add(i);
		}
		return result;
	}

}
