package leetCode.problems._849_Maximize_Distance_to_Closest_Person;

public class Solution {
	public int maxDistToClosest(int[] seats) {
		int[] dis = new int[seats.length];
		for (int i = 1; i < dis.length; i++) {
			if(seats[i]==0) {
				if(seats[i-1]==1||dis[i-1]!=0)
					dis[i] = dis[i-1]+1;
			}
		}
		int maxDis = dis[dis.length-1];
		for (int i = dis.length-2; i >=0; i--) {
			if(seats[i]==0) {
				if(dis[i]==0) {
					dis[i] = dis[i+1]+1;
				}else 
					dis[i] = Math.min(dis[i+1]+1, dis[i]);
				if(dis[i]>maxDis)
					maxDis = dis[i];
			}
		}
		return maxDis;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.maxDistToClosest(new int[] {1,0,0,0}));
	}
}
/*
849. Maximize Distance to Closest Person
Easy

In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

Example 2:

Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.

 

Constraints:

    2 <= seats.length <= 20000
    seats contains only 0s or 1s, at least one 0, and at least one 1.
 */