package leetCode.problems._861_Score_After_Flipping_Matrix;

public class Solution {
    public int matrixScore(int[][] A) {
        int rowC = A.length;
        int colC = A[0].length;
        int sum = 0;
        for (int i = 0; i < rowC; i++) {
        	int cur = 0;
			if(A[i][0]==0) {
				for (int j = 0; j < colC; j++) {
					cur<<=1;
					A[i][j] = 1-A[i][j];
					cur+=A[i][j];
				}
			}else {
				for (int j = 0; j < colC; j++) {
					cur<<=1;
					cur+=A[i][j];
				}
			}
			sum+=cur;
		}
        int delta = 0;
        for (int j = 0; j < colC; j++) {
        	delta<<=1;
        	int curDelta = 0;
			for (int i = 0; i < rowC; i++) {
				if(A[i][j]==0)
					curDelta++;
			}
			if(2*curDelta-rowC>0) {
				curDelta = 2*curDelta-rowC;
				delta+=curDelta;
			}	
		}
        
        return sum+delta;
    }
}
/*
861. Score After Flipping Matrix
Medium

We have a two dimensional matrix A where each value is 0 or 1.

A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.

After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.

Return the highest possible score.

 

Example 1:

Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
Output: 39
Explanation:
Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39

 

Note:

    1 <= A.length <= 20
    1 <= A[0].length <= 20
    A[i][j] is 0 or 1.
 */