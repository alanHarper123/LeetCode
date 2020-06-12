package leetCode.problems._661_Image_Smoother;

public class Solution {
	private int[][] dirs = new int[][] {{0,0},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1},{0,1},{0,-1}};
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] smoothIm = new int[row][col];
        int sum;
        int count;
        for (int i = 0; i < row; i++) {
        	for (int j = 0; j < col; j++) {
				count=0;
				sum=0;
				for (int[] dir:dirs) {
					int ni = i+dir[0];
					int nj = j+dir[1];
					if(ni<0||ni>=row||nj<0||nj>=col)
						continue;
					sum+=M[ni][nj];
					count++;
				}
				smoothIm[i][j] = sum/count;
			}
			
		}
        return smoothIm;
    }
}
