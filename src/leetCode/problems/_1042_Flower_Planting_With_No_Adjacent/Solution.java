package leetCode.problems._1042_Flower_Planting_With_No_Adjacent;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] gardenNoAdj(int N, int[][] paths) {
        int[] res = new int[N];
        boolean[] isPending = new boolean[N+1];
        int[][] neigbors = new int[N+1][5];
        for (int i = 1; i < neigbors.length; i++) {
			neigbors[i][0] = i;
			neigbors[i][4] = 1;
		}
        for(int[] path:paths) {
        	int[] u = neigbors[path[0]];
        	int[] v = neigbors[path[1]];
        	u[u[4]++] = path[1];
        	v[v[4]++] = path[0];
        }
        for (int i = 0; i < N; i++) {
			if(res[i]==0) {
				LinkedList<int[]> frontiers = new LinkedList<>();
				frontiers.add(neigbors[i+1]);
				isPending[i+1]=true;
				while (!frontiers.isEmpty()) {
					int size = frontiers.size();
					while (size>0) {
						size--;
						int[] v = frontiers.pollFirst();
						boolean[] judges = new boolean[5];
						for (int j = 1; j < v[4]; j++) {
							if(res[v[j]-1]!=0) {
								judges[res[v[j]-1]] = true;
							}
						}
						int k=1;
						while (judges[k]) {
							k++;
						}
						res[v[0]-1] = k;
				    	for (int j = 1; j < v[4]; j++) {
							if(res[v[j]-1]==0) {
								if(!isPending[v[j]]) {
									isPending[v[j]] = true;
									frontiers.add(neigbors[v[j]]);
								}
								
							}
						}
					}
				}
			}
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().gardenNoAdj(5, new int[][] {{3,4},{4,5},{3,2},{5,1},{1,3},{4,2}})));
	}
}
/*
1042. Flower Planting With No Adjacent
Easy

You have N gardens, labelled 1 to N.  In each garden, you want to plant one of 4 types of flowers.

paths[i] = [x, y] describes the existence of a bidirectional path from garden x to garden y.

Also, there is no garden that has more than 3 paths coming into or leaving it.

Your task is to choose a flower type for each garden such that, for any two gardens connected by a path, they have different types of flowers.

Return any such a choice as an array answer, where answer[i] is the type of flower planted in the (i+1)-th garden.  The flower types are denoted 1, 2, 3, or 4.  It is guaranteed an answer exists.

 

Example 1:

Input: N = 3, paths = [[1,2],[2,3],[3,1]]
Output: [1,2,3]

Example 2:

Input: N = 4, paths = [[1,2],[3,4]]
Output: [1,2,1,2]

Example 3:

Input: N = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
Output: [1,2,3,4]

 

Note:

    1 <= N <= 10000
    0 <= paths.size <= 20000
    No garden has 4 or more paths coming into or leaving it.
    It is guaranteed an answer exists.

*/