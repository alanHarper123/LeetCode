package leetCode.problems._413_Arithmetic_Slices;

public class Solution {
    public int numberOfArithmeticSlices(int[] A) {
    	int conTC = 0;
    	int slices = 0;
    	int totalSlices = 0;
        for (int i = 0; i < A.length-2; i++) {
			if(A[i+1]-A[i]==A[i+2]-A[i+1]) {
				conTC++;
				slices+=conTC;
			}else {
				totalSlices+=slices;
				conTC=0;
				slices=0;
			}
		}
		totalSlices+=slices;
		return totalSlices;
    }
}
