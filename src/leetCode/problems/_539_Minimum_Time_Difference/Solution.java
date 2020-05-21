package leetCode.problems._539_Minimum_Time_Difference;

import java.util.Collections;
import java.util.List;

public class Solution {
	private int minDif;
	private int minutesofTwelveHours = 12*60;
	private int minutesofOneday = 24*60;
    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        minDif = Integer.MAX_VALUE;
        String pre = timePoints.get(timePoints.size()-1);
        for(String timePoint:timePoints) {
        	if(pre!=null) {
        		int dif = (timePoint.charAt(0)-pre.charAt(0))*10;
        		dif += timePoint.charAt(1)-pre.charAt(1);
        		dif*=60;
        		dif += (timePoint.charAt(3)-pre.charAt(3))*10;
        		dif += timePoint.charAt(4)-pre.charAt(4);
        		if(dif<0)
        			dif = -dif;
        		if(dif>minutesofTwelveHours)
        			dif = minutesofOneday-dif;
        		if(dif<minDif)
        			minDif = dif;
        	}
        	pre = timePoint;
        }
        return minDif;
    }
}
