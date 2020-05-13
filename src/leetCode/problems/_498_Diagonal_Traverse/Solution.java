package leetCode.problems._498_Diagonal_Traverse;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
    	if(matrix==null||matrix.length==0)
    		return new int[0];
    	int rowC=matrix.length;
    	int colC=matrix[0].length;
        int count = rowC*colC;
        int[] layouts = new int[count];
        int i=0,j=0;
        boolean isUp = true;
        int k=0;
        while (k<count) {
        	if(isUp) {
        		do {
    				layouts[k++] = matrix[i--][j++];
    			} while (i>=0&&j<colC);
        		if(j==colC) {
        			j=colC-1;
    				i+=2;
        		}
        		if(i==-1) {
        			i=0;
        		}
        	}else {
        		do {
    				layouts[k++] = matrix[i++][j--];
    			} while (i<rowC&&j>=0);
        		if(i==rowC) {
        			i--;
        			j+=2;
        		}
        		if(j==-1) {
        			j=0;
        		}
        	}
			isUp=!isUp;
		}
        return layouts;
    }
}
