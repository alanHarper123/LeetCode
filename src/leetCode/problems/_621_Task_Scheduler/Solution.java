package leetCode.problems._621_Task_Scheduler;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
    	if(tasks==null||tasks.length==0)
    		return 0;
    	n++;
    	if(n==1)
    		return tasks.length;
        Integer[] taskTypeCounts = new Integer[26];
        Arrays.fill(taskTypeCounts, 0);
        for (char task:tasks) {
			taskTypeCounts[task-'A']++;
		}
        Arrays.sort(taskTypeCounts,Collections.reverseOrder());
        int totalCount=0;
        if(n<26&&taskTypeCounts[n]>0) {
        	while (taskTypeCounts[n]>0) {
				totalCount+=n;
				for (int i = 0; i < n; i++) {
					taskTypeCounts[i]--;
				}
				if(taskTypeCounts[n]>taskTypeCounts[n-1]) {
					int difL = 2;
					int i = n-difL;
					while(i>=0&&taskTypeCounts[i]<taskTypeCounts[i+difL]) {
						difL++;
						i--;
					}
					i++;
					difL--;
					int temp = taskTypeCounts[i];
					while (i+difL<taskTypeCounts.length&&temp<taskTypeCounts[i+difL]) {
						taskTypeCounts[i] = taskTypeCounts[i+difL];
						i++;
					}
					for (int j = 0; j < difL; j++) {
						taskTypeCounts[i+j] = temp;
					}
				}
			}
        }
        totalCount += n*(taskTypeCounts[0]-1)+1;
    	for (int i = 1; i < taskTypeCounts.length; i++) {
			if(taskTypeCounts[i].equals(taskTypeCounts[0]))
				totalCount++;
			else 
				break;	
		}
    	return totalCount; 
    }
    public static void main(String[] args) {
//		char[] test = new char[] {'A','B','C','D','A','B','V'};
		Solution solution = new Solution();
//		System.out.println(solution.leastInterval(test, 3));
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\alan\\Desktop\\text.txt"))){
		    String line = br.readLine();
		    char[] test2 = new char[(line.length()+1)/4];
		    for (int i = 1,j=0; j < test2.length; i+=4,j++) {
				test2[j] = line.charAt(i);
			}
		    System.out.println(solution.leastInterval(test2, 80));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
