package leetCode.problems._74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m==0)
        	return false;
        int n = matrix[0].length;
        if(n==0)
        	return false;
        int begin = 0;
        int end = m*n;
        int index;
        while (begin<end) {
			index = (begin+end)/2;
			if (matrix[index/n][index%n]>target) 
				end = index;
			else if(matrix[index/n][index%n]<target)
				begin = index+1;
			else 
				return true;			
		}
        return false;
    }
}
