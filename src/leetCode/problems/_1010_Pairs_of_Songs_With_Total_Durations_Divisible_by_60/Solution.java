package leetCode.problems._1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60;

public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] counts = new int[60];
        for(int td:time) {
        	counts[td%60]++;
        }
        int sum=0;
        for (int i = 1; i < 30; i++) {
			sum+=counts[i]*counts[60-i];
		}
        if(counts[0]>1) 
        	sum+=(counts[0]*(counts[0]-1))/2;
        if(counts[30]>1) 
        	sum+=(counts[30]*(counts[30]-1))/2;
        return sum;
    }
}
