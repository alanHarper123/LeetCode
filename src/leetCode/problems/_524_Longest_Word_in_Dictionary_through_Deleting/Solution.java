package leetCode.problems._524_Longest_Word_in_Dictionary_through_Deleting;

import java.util.List;

public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String lw = "";
        for(String string:d) {
        	if(string.length()>s.length()||string.length()<lw.length()
        			||(string.length()==lw.length()&&String.CASE_INSENSITIVE_ORDER.compare(lw, string)<0))
        		continue;
        	if(findSubsequence(s, string)) {
        		lw = string;
        	}
        }
        return lw;
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
