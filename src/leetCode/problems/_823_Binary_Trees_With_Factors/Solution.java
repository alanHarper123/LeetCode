package leetCode.problems._823_Binary_Trees_With_Factors;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	int mod = (int) 1e9 + 7;
    public int numFactoredBinaryTrees(int[] A) {
        Arrays.sort(A);
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
			valToIndex.put(A[i], i);
		}
        int count = 0;
        int[] counts = new int[A.length];
        for (int i = 0; i < A.length; i++) {
			int root = (int) Math.sqrt(A[i]);
			long curCount = 1;
			for (int j = 0; A[j] <= root; j++) {
				if(A[i]%A[j]==0) {
					int val = A[i]/A[j];
					Integer index = valToIndex.get(val);
					if(index!=null) {
						
						int reverseIn = 1;
						if(j!=index) {
							reverseIn=2;
						}
						long localCount = (long)counts[j]*counts[index]*reverseIn;
						curCount+=localCount;
						curCount%=mod;
					}
				}
			}
			counts[i] = (int) curCount;
			count+=curCount;
			count%=mod;
		}
        return count;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numFactoredBinaryTrees(new int[] {2, 4, 5, 10}));
	}
}
