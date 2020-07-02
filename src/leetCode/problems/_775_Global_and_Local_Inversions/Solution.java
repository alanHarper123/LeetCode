package leetCode.problems._775_Global_and_Local_Inversions;

public class Solution {
    public boolean isIdealPermutation(int[] A) {
        for (int i = 1; i < A.length; i++) {
			if(A[i-1]>A[i]&&(A[i-1]!=i||A[i]!=i-1))
				return false;
		}
        return true;
    }
}
