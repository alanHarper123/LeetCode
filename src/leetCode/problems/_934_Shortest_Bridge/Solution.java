package leetCode.problems._934_Shortest_Bridge;

import java.util.LinkedList;

public class Solution {
	int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] A) {
        int step = 0;
        LinkedList<Integer> bfsFrontiers = new LinkedList<>();
        int row = A.length;
        int col = A[0].length;
        loop1:for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(A[i][j]==1) {
					getGroup1(bfsFrontiers, A, i, j, row, col);
					break loop1;
				}
			}
		}
        int ni,nj,r,c;
        while (!bfsFrontiers.isEmpty()) {
			int size = bfsFrontiers.size()/2;
			while (size>0) {
				size--;
				r = bfsFrontiers.pollFirst();
				c = bfsFrontiers.pollFirst();
				for(int[] dir:dirs) {
		    		ni=r+dir[0];
		    		nj=c+dir[1];
		    		if(ni>=0&&ni<row&&nj>=0&&nj<col) {
		    			switch (A[ni][nj]) {
						case 0:
							bfsFrontiers.add(ni);
							bfsFrontiers.add(nj);
							A[ni][nj] = 2;
							break;
						case 1:
							return step;
						default:
							break;
						}
		    		}	
		    	}
			}
			step++;
		}
        return -1;
    }
    private void getGroup1(LinkedList<Integer> bfsFrontiers,int[][] A,
    		int i,int j,int row,int col) {
    	bfsFrontiers.add(i);
    	bfsFrontiers.add(j);
    	A[i][j] = 2;
    	int ni,nj;
    	for(int[] dir:dirs) {
    		ni=i+dir[0];
    		nj=j+dir[1];
    		if(ni>=0&&ni<row&&nj>=0&&nj<col&&A[ni][nj]==1)
    			getGroup1(bfsFrontiers, A, ni, nj, row, col);
    	}
    }
}
/*
934. Shortest Bridge
Medium

In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)

Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.

Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)

 

Example 1:

Input: A = [[0,1],[1,0]]
Output: 1

Example 2:

Input: A = [[0,1,0],[0,0,0],[0,0,1]]
Output: 2

Example 3:

Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
Output: 1

 

Constraints:

    2 <= A.length == A[0].length <= 100
    A[i][j] == 0 or A[i][j] == 1
 */