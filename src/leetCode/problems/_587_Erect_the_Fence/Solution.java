package leetCode.problems._587_Erect_the_Fence;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
	public int[][] outerTrees(int[][] points) {
		if(points==null||points.length==0)
			return points;
		Arrays.sort(points,(p1,p2)->{
			if(p1[0]==p2[0])
				return p2[1]-p1[1];
			else 
				return p1[0]-p2[0];
		});

		LinkedList<int[]> primeter = new LinkedList<>();
		int xMin = points[0][0];
		int i = 0;
		boolean[][] isPointTaken = new boolean[101][101];
		for (; i < points.length; i++) {
			if(points[i][0]==xMin) {
				primeter.addFirst(points[i]);
			}
			else 
				break;	
		}
		if(i!=points.length) {
			i--;
			LinkedList<Double> slopes = new LinkedList<>();
			slopes.add(Double.MAX_VALUE);
			int start=i;
			for (;start<points.length;start++) {
				while (true) {
					int[] pre = primeter.peekLast();
					double slope = (((double)points[start][1]-pre[1])/((double)points[start][0]-pre[0]));
					if(slope>slopes.peekLast()) {
						slopes.pollLast();
						primeter.pollLast();
					}else {
						slopes.add(slope);
						primeter.add(points[start]);
						break;
					}
				}
				while (start+1<points.length&&points[start][0]==points[start+1][0]) {
					start++;
				}
			}
			primeter.add(points[points.length-1]);
			slopes.add(-Double.MAX_VALUE);
			for (start--;start>=i;start--) {
				while (true) {
					int[] pre = primeter.peekLast();
					double slope = (((double)points[start][1]-pre[1])/((double)pre[0]-points[start][0]));
					if(slope<slopes.peekLast()) {
						slopes.pollLast();
						primeter.pollLast();
					}else {
						slopes.add(slope);
						primeter.add(points[start]);
						break;
					}
				}
				while (start-1>=i&&points[start][0]==points[start-1][0]) {
					start--;
				}
			}
			int xMax = points[points.length-1][0];
			int end = points.length-1;
			for (;end>=i;end--) {
				if(points[end][0]==xMax) {
					primeter.add(points[end]);
				}	
				else 
					break;
			}
			
			
		}
		int[][] primeterArray = new int[primeter.size()][2];
		int counti=0;
		while (!primeter.isEmpty()) {
			int[] point = primeter.pollFirst();
			if(isPointTaken[point[0]][point[1]]==false) {
				primeterArray[counti++] = point;
				isPointTaken[point[0]][point[1]] = true;
			}
			
		}
		return Arrays.copyOf(primeterArray, counti);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] test = new int[][] {{0,0},{0,100},{100,100},{100,0},{50,50}};
		int[][] result = solution.outerTrees(test);
		System.out.println(result);
	}
}
