package leetCode.problems._542_01_Matrix;

import java.util.LinkedList;

public class Solution {
	private static int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] updateMatrix(int[][] matrix) {
    	int rowC = matrix.length;
    	int colC = matrix[0].length;
        boolean[][] isVisited = new boolean[rowC][colC];
        LinkedList<Integer> bfs_frontiers = new LinkedList<>();
        for (int i = 0; i <rowC; i++) {
			for (int j = 0; j < colC; j++) {
				if(matrix[i][j]==0) {
					bfs_frontiers.add(i);
					bfs_frontiers.add(j);
				}
			}
		}
        while (!bfs_frontiers.isEmpty()) {
			int b_count = bfs_frontiers.size()/2;
			while (b_count>0) {
				b_count--;
				int row = bfs_frontiers.pollFirst();
				int col = bfs_frontiers.pollFirst();
				for (int[]dir:dirs) {
					row+=dir[0];
					col+=dir[1];
					if(row>=0&&row<rowC&&col>=0&&col<colC&&
							matrix[row][col]==1&&isVisited[row][col]==false) {
						matrix[row][col] = matrix[row-dir[0]][col-dir[1]]+1;
						isVisited[row][col]=true;
						bfs_frontiers.add(row);
						bfs_frontiers.add(col);
						
					}
					row-=dir[0];
					col-=dir[1];
						
				}
			}
		}
        return matrix;
    }
}
