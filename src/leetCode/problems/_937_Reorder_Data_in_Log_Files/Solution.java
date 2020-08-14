package leetCode.problems._937_Reorder_Data_in_Log_Files;

import java.util.Arrays;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        String[][] nLogs = new String[logs.length][];
        int i=0;
        for(String log:logs) {
        	nLogs[i++] = log.split(" ", 2);
        }
        Arrays.sort(nLogs, (log1,log2)->{
        	if(log1[1].charAt(0)>='0'&&log1[1].charAt(0)<='9') {
        		return (log2[1].charAt(0)>='0'&&log2[1].charAt(0)<='9')?0:1;
        	}
        	else if(log2[1].charAt(0)>='0'&&log2[1].charAt(0)<='9') {
        		return -1;
        	}else {
        		int c = log1[1].compareTo(log2[1]);
        		if(c==0) {
        			return log1[0].compareTo(log2[0]);
        		}
        		return c;
        	}
        });
        for (int j = 0; j < nLogs.length; j++) {
			logs[j] = nLogs[j][0]+" "+nLogs[j][1];
		}
        return logs;
    }
}
