package leetCode.problems._892_Surface_Area_of_3D_Shapes;

public class Solution {
	int[][] dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        int rowC = grid.length;
        int colC = grid[0].length;
        for (int i = 0,val,ni,nj,dif; i < rowC; i++) {
			for (int j = 0; j < colC; j++) {
				val = grid[i][j];
				if(val!=0) {
					sum+=2;
					for(int[] dir:dirs) {
						ni = i+dir[0];
						nj = j+dir[1];
						if(ni<0||ni>=rowC||nj<0||nj>=colC) {
							sum+=val;
						}else {
							dif = val - grid[ni][nj];
							if(dif>0)
								sum+=dif;
						}
							
					}
				}
			}
		}
        return sum;
    }
}
