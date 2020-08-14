package leetCode.problems._939_Minimum_Area_Rectangle;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int minAreaRect(int[][] points) {
        Arrays.sort(points,(p1,p2)->{
        	if(p1[0]==p2[0])
        		return p1[1]-p2[1];
        	return p1[0]-p2[0];
        });
        LinkedList<Integer> index = new LinkedList<>();
        int x, start,starti, end,endi,
        targetlx,targetli1,targetli2,targetry1,
        targetrx,targetri2;
        int minArea = Integer.MAX_VALUE;
        for (int i = 0; i < points.length;) {
			start = i;
			x = points[i][0];
			targetrx = points[i][0];
			while (i+1<points.length&&points[i+1][0]==points[i][0]) {
				i++;
				Iterator<Integer> iterator = index.iterator();
				targetry1 = points[i][1];
				loop1:while (iterator.hasNext()) {
					targetri2 = i-1;
					endi = iterator.next();
					starti = iterator.next();
					targetlx = iterator.next();
					targetli1 = binarySearch(points, starti, endi, targetry1);
					if(targetli1<0)
						continue;
					endi = targetli1;
					while (targetri2>=start&&endi>starti) {
						targetli2 = binarySearch(points, starti, endi, points[targetri2][1]);
						if(targetli2<0) {
							endi = -(targetli2+1);
						}else {
							if(minArea>(targetrx-targetlx)*(targetry1-points[targetri2][1])) {
								minArea = (targetrx-targetlx)*(targetry1-points[targetri2][1]);
							}
							continue loop1;
						}
						targetri2--;
					}
				}
			}
			i++;
			end = i;
			index.addFirst(x);
			index.addFirst(start);
			index.addFirst(end);
		}
        return minArea==Integer.MAX_VALUE?0:minArea;
    }
    private int binarySearch(int[][] points,int start,int end,int target) {
    	int mid;
    	while (start<end) {
			mid = start+(end-start)/2;
			if(points[mid][1]<target)
				start = mid+1;
			else if(points[mid][1]>target) {
				end = mid;
			}else 
				return mid;
		}
    	return -start-1;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().minAreaRect(new int[][]{{3,2},{3,3},{4,5},{4,4},{5,4},{3,5},{2,4},{1,5},{0,5},{0,4},{4,0},{0,2},{5,3}}));
	}
}
/*
939. Minimum Area Rectangle
Medium

Given a set of points in the xy-plane, determine the minimum area of a rectangle formed from these points, with sides parallel to the x and y axes.

If there isn't any rectangle, return 0.

 

Example 1:

Input: [[1,1],[1,3],[3,1],[3,3],[2,2]]
Output: 4

Example 2:

Input: [[1,1],[1,3],[3,1],[3,3],[4,1],[4,3]]
Output: 2

 

Note:

    1 <= points.length <= 500
    0 <= points[i][0] <= 40000
    0 <= points[i][1] <= 40000
    All points are distinct.
 */