package leetCode.problems._977_Squares_of_a_Sorted_Array;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] A) {
        int [] res = new int[A.length];
        int zi = Arrays.binarySearch(A, 0);
        if(zi<0) 
        	zi = -(zi+1)-1;
        else 
			zi--;
        int i = zi+1;
        int zVal=0, val=0,j=0;
        if(i<A.length) 
        	val = A[i]*A[i];
        if(zi>=0)
        	zVal = A[zi]*A[zi];
        while (i<A.length&&zi>=0) {
			if(zVal>val) {
				res[j++] = val;
				i++;
				if(i<A.length) 
					val = A[i]*A[i];
				
			}else {
				res[j++] = zVal;
				zi--;
				if(zi>=0)
					zVal = A[zi]*A[zi];
			}
		}
        while (i<A.length) {
        	res[j++] = val;
			i++;
			if(i<A.length) 
				val = A[i]*A[i];
		}
        while (zi>=0) {
        	res[j++] = zVal;
			zi--;
			if(zi>=0)
				zVal = A[zi]*A[zi];
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().sortedSquares(new int[] {-1,2,2}));
	}
}
