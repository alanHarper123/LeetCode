package leetCode.problems._883_Projection_Area_of_3D_Shapes;

public class Solution {
    public int projectionArea(int[][] grid) {
        int area = 0;
        int[] a_row = new int[grid.length];
        int[] a_col = new int[grid[0].length];
        for (int i = 0,h; i < a_row.length; i++) {
			for (int j = 0; j < a_col.length; j++) {
				h = grid[i][j];
				if(h>0) {
					area++;
					if(h>a_row[i])
						a_row[i] = h;
					if(h>a_col[j])
						a_col[j] = h;
				}
			}
		}
        for (int i = 0; i < a_col.length; i++) {
			area+=a_col[i];
		}
        for (int i = 0; i < a_row.length; i++) {
        	area+=a_row[i];
		}
        return area;
    }
}
