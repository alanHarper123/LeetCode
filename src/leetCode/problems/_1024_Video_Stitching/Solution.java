package leetCode.problems._1024_Video_Stitching;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        int[] ends = new int[T+1];
        Arrays.fill(ends, -1);
        for(int[] clip:clips) {
        	if(clip[0]<=T&&clip[1]>ends[clip[0]])
        		ends[clip[0]] = clip[1];
        }
        if(ends[0]>=T)
        	return 1;
        LinkedList<Integer> frontiers = new LinkedList<>();
        boolean[] visited = new boolean[T+1];

        frontiers.add(ends[0]);
        frontiers.add(0);
		visited[0] = true;
        int res = 1;
        while (!frontiers.isEmpty()) {
        	res++;
			int size = frontiers.size()/2;
			while (size>0) {
				size--;
				int end = frontiers.pollFirst();
				int start = frontiers.pollFirst();
				for (int i = Math.min(T, end); i > start; i--) {
					if(ends[i]!=-1&&!visited[i]) {
						if(ends[i]>=T)
							return res;
						visited[i] = true;
						frontiers.add(ends[i]);
						frontiers.add(i);
					}
				}
			}
		}
        return -1;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().videoStitching(new int[][] {{0,1},{6,8},
			{0,2},{5,6},{0,4},{0,3},{6,7},{1,3},{4,7},{1,4},{2,5},{2,6},{3,4},{4,5},
			{5,7},{6,9}}, 9));
	}
}
