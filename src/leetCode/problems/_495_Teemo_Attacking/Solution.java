package leetCode.problems._495_Teemo_Attacking;

public class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries==null||timeSeries.length==0)
        	return 0;
        if(timeSeries.length==1)
        	return duration;
        int totalTime = 0;
        for (int i = 1; i < timeSeries.length; i++) {
        	int dif = timeSeries[i]-timeSeries[i-1];
			if(dif>duration)
				totalTime+=duration;
			else 
				totalTime+=dif;
		}
        totalTime+=duration;
        return totalTime;
    }
}
