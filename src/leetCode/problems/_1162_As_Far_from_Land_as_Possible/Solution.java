package leetCode.problems._1162_As_Far_from_Land_as_Possible;

import java.util.LinkedList;

public class Solution {
	int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int maxDistance(int[][] grid) {
        LinkedList<Integer> frontiers = new LinkedList<>();
        int rowC = grid.length;
        int colC = grid[0].length;
        for (int i = 0; i < rowC; i++) {
			for (int j = 0; j < colC; j++) {
				if(grid[i][j]==1) {
					frontiers.add(i);
					frontiers.add(j);
				}	
			}
		}
        int dist = -1;
        while (!frontiers.isEmpty()) {
			int size = frontiers.size()/2;
			while (size>0) {
				size--;
				int i = frontiers.pollFirst();
				int j = frontiers.pollFirst();
				for(int[] dir:dirs) {
					int ni = i+dir[0];
					int nj = j+dir[1];
					if(ni>=0&&ni<rowC&&nj>=0&&nj<colC&&grid[ni][nj]==0) {
						grid[ni][nj] = 1;
						frontiers.add(ni);
						frontiers.add(nj);
					}
				}
			}
			dist++;
		}
        return dist==0?-1:dist;
    }
}
