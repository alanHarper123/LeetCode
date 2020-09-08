package leetCode.problems._1030_Matrix_Cells_in_Distance_Order;

import java.util.LinkedList;

public class Solution {
	int[][] allDirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
	
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] res = new int[R*C][2];
        int c = 0;
        res[c][0] = r0;
        res[c][1] = c0;
        c++;
        boolean[][] isVisited = new boolean[R][C];
        isVisited[r0][c0] = true;
        LinkedList<Integer> frontiers = new LinkedList<>();
        frontiers.add(r0);
        frontiers.add(c0);
        int ni,nj,i,j;
        while (c<R*C) {	
        	int size = frontiers.size()/2;
        	while (size>0) {
        		size--;
                i = frontiers.pollFirst();
                j = frontiers.pollFirst();
            	for(int[] dir:allDirs) {
            		ni = dir[0]+i;
            		nj = dir[1]+j;
            		if(ni>=0&&ni<R&&nj>=0&&nj<C&&!isVisited[ni][nj]) {
            			isVisited[ni][nj] = true;
            			res[c][0] = ni;
            			res[c++][1] = nj;
            			frontiers.add(ni);
            	        frontiers.add(nj);
            		}	
            	}
			}
		}
        return res; 
    }
}
