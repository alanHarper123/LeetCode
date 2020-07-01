package leetCode.problems._766_Toeplitz_Matrix;

public class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int leftR = row-1;
        int leftC = 0;
        int rightR = row - 1;
        int rightC = 0;
        for (int i = 0; i < row+col-3; i++) {
			if(leftR==0)
				leftC++;
			else 
				leftR--;
			if(rightC<col-1)
				rightC++;
			else 
				rightR--;
			int leftR_runner = leftR;
			int leftC_runner = leftC;
			int rightR_runner = rightR;
	        int rightC_runner = rightC;
	        int keyVal = matrix[leftR_runner][leftC_runner];
	        while (leftR_runner<=rightR_runner) {
				if(matrix[leftR_runner][leftC_runner]!=keyVal||
						matrix[rightR_runner][rightC_runner]!=keyVal)
					return false;
				leftR_runner++;
				leftC_runner++;
				rightR_runner--;
				rightC_runner--;
			}
		}
        return true;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] test = new int[][] {{1,2},{2,2}};
		System.out.println(solution.isToeplitzMatrix(test));
	}
}
/*
Example 1:

Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.

Example 2:

Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.


Note:

    matrix will be a 2D array of integers.
    matrix will have a number of rows and columns in range [1, 20].
    matrix[i][j] will be integers in range [0, 99].


Follow up:

    What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
    What if the matrix is so large that you can only load up a partial row into the memory at once?

*/
