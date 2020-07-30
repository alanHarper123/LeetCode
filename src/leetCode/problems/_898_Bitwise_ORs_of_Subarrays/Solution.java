package leetCode.problems._898_Bitwise_ORs_of_Subarrays;

import java.util.HashSet;

public class Solution {
	public int subarrayBitwiseORs(int[] A) {
		HashSet<Integer> pre = new HashSet<>();
		HashSet<Integer> cur = new HashSet<>();
		HashSet<Integer> all = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			cur.add(A[i]);
			for (Integer e:pre) {
				cur.add(e|A[i]);
			}
			all.addAll(cur);
			pre = cur;
			cur = new HashSet<>();
		}
		return all.size();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().subarrayBitwiseORs(new int[] {1,1,2}));
	}
}
