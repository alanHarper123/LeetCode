package leetCode.problems._401_Binary_Watch;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	private LinkedList<Integer> combinations;
	private static int minuteMask = 1+2+4+8+16+32;
    public List<String> readBinaryWatch(int num) {
    	combinations = new LinkedList<>();
    	getCombinations(0, num, 10);
    	LinkedList<String> times = new LinkedList<>();
        for(Integer combination : combinations) {
        	String hours = String.valueOf(combination>>6);
        	String minutes = String.valueOf(combination&minuteMask);
        	if(minutes.length()<2)
        		minutes="0"+minutes;
        	String time = hours+":"+minutes;
        	times.addFirst(time);
        }
        return times;	
    }
    private void getCombinations(int pre, int num,int digitCount){
    	if(num==0) {
    		if((pre&minuteMask)<60) {
    			combinations.add(pre);
    		}
    		return;
    	}
    	if(digitCount==1) {
    		pre++;
    		if((pre&minuteMask)<60) {
    			combinations.add(pre);
    		}
    		return;
    	}
    	for (int i = digitCount; i > num-1; i--) {
    		if(i==9&&pre==(1<<9)) {
    			continue;
    		}
			getCombinations(pre+(1<<(i-1)), num-1, i-1);
		}	
    }
}
