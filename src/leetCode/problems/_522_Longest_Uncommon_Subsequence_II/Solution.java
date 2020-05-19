package leetCode.problems._522_Longest_Uncommon_Subsequence_II;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public int findLUSlength(String[] strs) {
        HashSet<Integer> visitedNodes = new HashSet<>();
        int lusL = -1;
        Arrays.sort(strs,(s1,s2)->s2.length()-s1.length());
        for (int j = 0; j < strs.length; j++) {
        	if(!visitedNodes.add(j)) {
        		continue;
        	};
        	int lusLj=strs[j].length();
        	boolean findE = false;
			for (int j2 = j+1; j2 < strs.length; j2++) {
	        	if(visitedNodes.contains(j2))
	        		continue;
				if(strs[j].length()==strs[j2].length()) {
					if(strs[j].equals(strs[j2])) {
						visitedNodes.add(j2);
						findE = true;
					}
				}else if (strs[j].length()>strs[j2].length()) {
					if(findSubsequence(strs[j],strs[j2])){
						visitedNodes.add(j2);
					}
				}else if (strs[j].length()<strs[j2].length()) {
					if(findSubsequence(strs[j2],strs[j])) {
						findE = true;
					}
				}
			}
			if(findE==false) {
				return Math.max(lusLj, lusL);
			}	
		}
        return lusL;
    }
    private boolean findSubsequence(String s1, String s2) {
    	int k=-1;
    	for (int i = 0; i < s2.length(); i++) {
			k = s1.indexOf(s2.charAt(i), k+1);
			if(k==-1)
				return false;
		}
    	return true;
    }
}
