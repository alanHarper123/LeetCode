package leetCode.problems._438_Find_All_Anagrams_in_a_String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    	char[] masks = p.toCharArray();
    	Arrays.sort(masks);
    	HashSet<Character> unipues = new HashSet<>();
    	for (int i = 0; i < masks.length; i++) {
			unipues.add(masks[i]);
		}
        LinkedList<Integer> indexs = new LinkedList<>();
        char[] chars = new char[p.length()];
        int end = s.length() - p.length();
        boolean isLastG = false;
        int lastGC = 0;
        loop1:for (int i = 0; i <= end;) {
        	if(isLastG) {
        		if(s.charAt(i+chars.length-1)==chars[lastGC]) {
            		lastGC=(lastGC+1)%p.length();
            		indexs.add(i);
        		}else {
        			isLastG = false;
        			lastGC = 0;
        			i++;
        			continue;
        		}
        			
        	}else {
        		for (int j = 0; j < chars.length; j++) {
            		char c = s.charAt(i+j);
            		if(unipues.contains(c)) {
            			chars[j] = c;
            		}else {
            			isLastG = false;
            			lastGC = 0;
            			i=i+j+1;
            			continue loop1;
            		}
    			}
        	}
        	
        	char[] charsR = Arrays.copyOf(chars, chars.length);
        	Arrays.sort(charsR);
        	if(compare(masks, charsR)) {
        		if(isLastG)
        			lastGC=(lastGC+1)%p.length();
        		isLastG=true;
        		indexs.add(i);
        	}else {
        		isLastG = false;
    			lastGC = 0;
        	}
        	i++;
		}
        return indexs;
    }
    private boolean compare(char[] masks,char[] chars) {
    	for (int i = 0; i < chars.length; i++) {
			if(chars[i]!=masks[i])
				return false;
		}
    	return true;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findAnagrams("cbaebabacd", "abc"));
	}
}
