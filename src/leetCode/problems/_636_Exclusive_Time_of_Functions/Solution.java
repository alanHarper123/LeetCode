package leetCode.problems._636_Exclusive_Time_of_Functions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] exclusiveTimes = new int[n];
        LinkedList<Integer> preStarts = new LinkedList<>();
        int preTime = -1;
        boolean isPreStart = true;
        int preN = 0;
        for(String log:logs) {
        	String[] info = log.split(":");
        	int num = Integer.valueOf(info[0]);
        	boolean isStart = info[1].equals("start");
        	int time = Integer.valueOf(info[2]);
        	if(isPreStart) {
        		if(preTime!=-1) {
        			exclusiveTimes[preN] += time-preTime+(isStart?0:1);
        		}
        	}else {
        		if(isStart) {
        			if(!isPreStart&&!preStarts.isEmpty()) {
        				exclusiveTimes[preStarts.peekLast()]+=time-preTime-1;
        			}
        		}else {
        			exclusiveTimes[num] += time-preTime;
        		}
        	}
        	if(isStart) {
        		preStarts.add(num);
        	}else {
        		preStarts.pollLast();      	}
        	isPreStart = isStart;
        	preN = num;
        	preTime=time;
        }
        return exclusiveTimes;
    }
    public static void main(String[] args) {
		LinkedList<String> test = new LinkedList<>();
		test.add("0:start:0");
		test.add("0:start:2");
		test.add("0:end:5");
		test.add("1:start:7");
		test.add("1:end:7");
		test.add("0:end:8");
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.exclusiveTime(2, test)));
	}
}
