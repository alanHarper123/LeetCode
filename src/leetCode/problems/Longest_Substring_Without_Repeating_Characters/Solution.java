package leetCode.problems.Longest_Substring_Without_Repeating_Characters;


import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
    	char[] charTemp = s.toCharArray();
        int longestSub = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int lower = 0, upper = 0;
        HashSet<Character> hashSet = new HashSet<>();
        for(char c :charTemp) {
        	hashSet.add(c);
        }

        for(int i=0; i<charTemp.length; i++) {
        	if (hashMap.get(charTemp[i])!=null) {
				if(hashMap.size()>longestSub) {
					longestSub = hashMap.size();
					if(longestSub==hashSet.size()) {
						return longestSub;
					}
				}
				upper = hashMap.get(charTemp[i]);
				for(int j=lower; j<upper; j++) {
					hashMap.remove(charTemp[j]);
				}
				
				lower = upper+1;
			}
			hashMap.put(charTemp[i], i);
			
        }
        if(hashMap.size()>longestSub) {
			longestSub = hashMap.size();
		}
        return longestSub;
    }
}
