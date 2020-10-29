package leetCode.problems._1207_Unique_Number_of_Occurrences;

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int[] counts = new int[2001];
        for(int e:arr) {
        	counts[e+1000]++;
        }
        boolean[] istaken = new boolean[1001];
        for(int ci:counts) {
        	if(ci!=0) {
        		if(istaken[ci])
        			return false;
        		istaken[ci] = true;
        	}
        }
        return true;
    }
}
