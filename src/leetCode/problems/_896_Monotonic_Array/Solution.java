package leetCode.problems._896_Monotonic_Array;

public class Solution {
    public boolean isMonotonic(int[] A) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for (int i = 1,dif; i < A.length; i++) {
        	dif = A[i]-A[i-1];
			if(dif>0) {
				if(isDecreasing)
					return false;
				isIncreasing = true;
			}else if(dif<0) {
				if(isIncreasing)
					return false;
				isDecreasing = true;
			}	
		}
        return true;
    }
}
