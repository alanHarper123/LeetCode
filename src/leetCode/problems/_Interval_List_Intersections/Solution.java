package leetCode.problems._Interval_List_Intersections;

import java.util.Arrays;

public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i=0;
        int j=0;
        int[][] intersects = new int[A.length+B.length][2];
        int index=0;
        while (i<A.length&&j<B.length) {
			if(B[j][1]<A[i][1]) {
				int[][] temp = A;
				int inTemp = i;
				i=j;
				j=inTemp;
				A=B;
				B=temp;
			}
			if(B[j][0]<=A[i][1]) {
				intersects[index++]=new int[] {Math.max(B[j][0], A[i][0]),A[i][1]};
			}
			i++;
		}
        return Arrays.copyOfRange(intersects, 0, index);
    }
}
