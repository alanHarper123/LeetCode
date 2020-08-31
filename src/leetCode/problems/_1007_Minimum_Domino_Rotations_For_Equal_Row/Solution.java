package leetCode.problems._1007_Minimum_Domino_Rotations_For_Equal_Row;

public class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int minC = Integer.MAX_VALUE;
        boolean failed;
        for (int i = 1,aC,bC; i < 7; i++) {
        	failed = false;
        	aC=0;
        	bC=0;
			for (int j = 0; j < B.length; j++) {
				if(A[j]!=i||B[j]!=i) {
					if(A[j]!=i&&B[j]!=i) {
						failed = true;
						break;
					}
					if(A[j]==i) 
						aC++;
					else 
						bC++;	
				}
			}
			if(!failed) {
				minC = Math.min(aC, minC);
				minC = Math.min(bC, minC);
				if(minC==0)
					return 0;
			}
		}
        return minC==Integer.MAX_VALUE?-1:minC;
    }
}
/*
1007. Minimum Domino Rotations For Equal Row
Medium

In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the i-th domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

 

Note:

    1 <= A[i], B[i] <= 6
    2 <= A.length == B.length <= 20000
 */