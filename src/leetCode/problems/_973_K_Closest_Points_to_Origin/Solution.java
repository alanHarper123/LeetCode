package leetCode.problems._973_K_Closest_Points_to_Origin;

import java.util.Arrays;
import java.util.Random;

public class Solution {
	private Random random = new Random(System.currentTimeMillis());
	int kthD;
	int i_Ult;
    public int[][] kClosest(int[][] points, int K) {
        int[] dis = new int[points.length];
        for (int i = 0; i < dis.length; i++) {
			dis[i] = points[i][0]*points[i][0]+points[i][1]*points[i][1];
		}
        findKth(points, dis, K, 0, dis.length);
        int[][] res = new int[K][];
        int i = 0;
        for (int j = 0; j < i_Ult; j++) {
			if(dis[j]<kthD) 
				res[i++] = points[j];
		}
        for (int j = 0; i<K&&j<K; j++) {
			if(dis[j]==kthD) 
				res[i++] = points[j];
		}
        return res;
    }
    private void findKth(int[][] points,int[] dis,int k,int start,int end) {
    	int pivot = dis[start + random.nextInt(end-start)];
    	int[] tempP;
    	int eC = 0;
    	int i = start;
    	for (int j=end-1,temp; i <= j;i++) {
			if(dis[i]>pivot) {
				temp = dis[i];
				dis[i] = dis[j];
				dis[j] = temp;
				tempP = points[i];
				points[i] = points[j];
				points[j] = tempP;
				i--;
				j--;
			}else if(dis[i]==pivot)
				eC++;
		}
    	if(k<i-eC) {
    		findKth(points, dis, k, start, i);
    	}else if(k>i) {
    		findKth(points, dis, k, i, end);
    	}else {
    		kthD = pivot;
    		i_Ult = i;
    	}
    		
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().kClosest(new int[][] {{68,97},{34,-84},{60,100},{2,31},{-27,-38},{-73,-74},{-55,-39},{62,91},{62,92},{-57,-67}}, 5)));
	}
}
/*
973. K Closest Points to Origin
Medium

We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

 

Note:

    1 <= K <= points.length <= 10000
    -10000 < points[i][0] < 10000
    -10000 < points[i][1] < 10000
 */