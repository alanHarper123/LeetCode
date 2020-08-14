package leetCode.problems._941_Valid_Mountain_Array;

public class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length<3)
        	return false;
        for (int i = 1; i < A.length; i++) {
			while (i<A.length&&A[i]>A[i-1]) {
				i++;
			}
			if(i==1||i>A.length-1)
				return false;
			i++;
			while (i<A.length&&A[i]<A[i-1]) {
				i++;
			}
			return i==A.length;
		}
        return false;
    }
}
