package leetCode.problems._1184_Distance_Between_Bus_Stops;

public class Solution {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int[] disSum = new int[distance.length+1];
        for (int i = 0; i < distance.length; i++) {
			disSum[i+1] = distance[i]+disSum[i];
		}
        int total = disSum[disSum.length-1];
        if(destination<start) {
        	int temp = destination;
        	destination = start;
        	start = temp;
        }
        int dif = disSum[destination]-disSum[start];
        return Math.min(dif, total-dif);
    }
}
