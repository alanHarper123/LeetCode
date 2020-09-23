package leetCode.problems._1091_Shortest_Path_in_Binary_Matrix;

import java.util.LinkedList;

public class Solution {
	private int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
    	int n = grid.length;
    	if(grid[0][0]!=0||grid[n-1][n-1]!=0)
    		return -1;
    	if(n==1)
    		return 1;
        boolean[][] isVisited = new boolean[n][n];
        LinkedList<Integer> frontiers = new LinkedList<>();
        frontiers.add(0);
        frontiers.add(0);
        isVisited[0][0] = true;
        int step = 1;
        while (!frontiers.isEmpty()) {
        	step++;
        	int size = frontiers.size()/2;
        	while (size>0) {
        		size--;
        		int i = frontiers.pollFirst();
        		int j = frontiers.pollFirst();
        		for(int[] dir:dirs) {
        			int ni = i+dir[0];
        			int nj = j+dir[1];
        			if(ni>=0&&ni<n&&nj>=0&&nj<n&&grid[ni][nj]==0&&!isVisited[ni][nj]) {
        				if(ni==n-1&&nj==n-1)
        					return step;
        				isVisited[ni][nj] = true;
        				frontiers.add(ni);
        				frontiers.add(nj);
        			}
        		}
				
			}
		}
        return -1;
    }
}
/*
1091. Shortest Path in Binary Matrix
Medium

In an N by N square grid, each cell is either empty (0) or blocked (1).

A clear path from top-left to bottom-right has length k if and only if it is composed of cells C_1, C_2, ..., C_k such that:

    Adjacent cells C_i and C_{i+1} are connected 8-directionally (ie., they are different and share an edge or corner)
    C_1 is at location (0, 0) (ie. has value grid[0][0])
    C_k is at location (N-1, N-1) (ie. has value grid[N-1][N-1])
    If C_i is located at (r, c), then grid[r][c] is empty (ie. grid[r][c] == 0).

Return the length of the shortest such clear path from top-left to bottom-right.  If such a path does not exist, return -1.

 

Example 1:

Input: [[0,1],[1,0]]


Output: 2

Example 2:

Input: [[0,0,0],[1,1,0],[1,1,0]]


Output: 4

 

Note:

    1 <= grid.length == grid[0].length <= 100
    grid[r][c] is 0 or 1

*/