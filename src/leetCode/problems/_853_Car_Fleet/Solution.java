package leetCode.problems._853_Car_Fleet;

import java.util.Arrays;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        sortArr1(position, speed, 0, position.length);
        int count = 0;
        for (int i = position.length-1; i >=0; i--) {
        	count++;
			int curSpeed = speed[i];
			int curPos = position[i];
			double t1 = (double)(target-curPos)/curSpeed;
			int deltaSpeed = 0;
			while (i-1>=0&&(deltaSpeed=speed[i-1]-curSpeed)>0) {
				if(deltaSpeed*t1>=curPos-position[i-1])
					i--;
				else 
					break;
			}
		}
        return count;
    }
    //sort arr1, and change arr2 accordingly.
    private void sortArr1(int[] arr1, int[] arr2,int start,int end) {
    	if(end-start<=1)
    		return;
    	int mid = (end+start)/2;
    	sortArr1(arr1, arr2, start, mid);
    	sortArr1(arr1, arr2, mid, end);
    	int[] dif1 = Arrays.copyOfRange(arr1, start, mid);
    	int[] pfoF1 = Arrays.copyOfRange(arr2, start, mid);
    	int[] dif2 = Arrays.copyOfRange(arr1, mid, end);
    	int[] pfoF2 = Arrays.copyOfRange(arr2, mid, end);
    	int d1 = 0, d2 = 0;
    	while (d1<dif1.length&&d2<dif2.length) {
			if(dif1[d1]>dif2[d2]) {
				arr1[start] = dif2[d2];
				arr2[start++] = pfoF2[d2++];
			}else {
				arr1[start] = dif1[d1];
				arr2[start++] = pfoF1[d1++];
			}
		}
    	while (d1<dif1.length) {
    		arr1[start] = dif1[d1];
			arr2[start++] = pfoF1[d1++];
		}
    	while (d2<dif2.length) {
			arr1[start] = dif2[d2];
			arr2[start++] = pfoF2[d2++];
		}
    }
}
/*
853. Car Fleet
Medium

N cars are going to the same destination along a one lane road.  The destination is target miles away.

Each car i has a constant speed speed[i] (in miles per hour), and initial position position[i] miles towards the target along the road.

A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

The distance between these two cars is ignored - they are assumed to have the same position.

A car fleet is some non-empty set of cars driving at the same position and same speed.  Note that a single car is also a car fleet.

If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.


How many car fleets will arrive at the destination?

 

Example 1:

Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
Output: 3
Explanation:
The cars starting at 10 and 8 become a fleet, meeting each other at 12.
The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
The cars starting at 5 and 3 become a fleet, meeting each other at 6.
Note that no other cars meet these fleets before the destination, so the answer is 3.


Note:

    0 <= N <= 10 ^ 4
    0 < target <= 10 ^ 6
    0 < speed[i] <= 10 ^ 6
    0 <= position[i] < target
    All initial positions are different.
 */