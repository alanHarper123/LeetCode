package leetCode.problems._976_Largest_Perimeter_Triangle;

import java.util.Arrays;

public class Solution {
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i = A.length-3; i >=0; i--) {
			if(A[i]>A[i+2]-A[i+1])
				return A[i]+A[i+1]+A[i+2];
		}
        return 0;
    }
}
