package leetCode.problems._396_Rotate_Function;

public class Solution {
    public int maxRotateFunction(int[] A) {
        int max = Integer.MIN_VALUE;
        int maxi = 0;
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
			sum+=A[i];
			maxi+=i*A[i];
		}
        if(max<maxi)
        	max = maxi;
        for (int i = 1; i < A.length; i++) {
			maxi = maxi-sum+A.length*A[i-1];
			if(max<maxi)
	        	max = maxi;
		}
        return max;
    }
}
