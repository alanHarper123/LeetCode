package leetCode.problems._395_Longest_Substring_with_At_Least_K_Repeating_Characters;

import java.util.HashMap;

public class Solution {
    public int longestSubstring(String s, int k) {
        if(k<=1)
        	return s.length();
        HashMap<Character, Integer> repeatCs = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
			Integer c = repeatCs.get(s.charAt(i));
			if(c==null)
				c=0;
			c++;
			repeatCs.put(s.charAt(i), c);
		}
        int max=0;
        int maxi=0;
        int i = 0;
        for (; i < s.length(); i++) {
			if(repeatCs.get(s.charAt(i))>=k)
				maxi++;
			else {
				if(maxi>=k&&maxi>max) {
					int count = longestSubstring(s.substring(i-maxi, i), k);
					if(count>max)
						max = count;
				}
				maxi=0;
			}
		}
        if(maxi==s.length())
        	return s.length();
        if(maxi>=k&&maxi>max) {
			int count = longestSubstring(s.substring(i-maxi, i), k);
			if(count>max)
				max = count;
		}
        return max;
    }
}
