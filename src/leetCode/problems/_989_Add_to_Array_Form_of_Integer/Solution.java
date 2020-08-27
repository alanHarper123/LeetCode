package leetCode.problems._989_Add_to_Array_Form_of_Integer;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> res = new LinkedList<>();
        for (int i = A.length-1; i >=0; i--) {
			K+=A[i];
			res.addFirst(K%10);
			K/=10;
		}
        while (K!=0) {
        	res.addFirst(K%10);
			K/=10;
		}
        return res;
    }
}
