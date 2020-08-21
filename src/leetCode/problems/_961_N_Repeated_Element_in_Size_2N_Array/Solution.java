package leetCode.problems._961_N_Repeated_Element_in_Size_2N_Array;

import java.util.HashSet;

public class Solution {
    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
			if(!set.add(A[i]))
				return A[i];
		}
        return -1;
    }
}
