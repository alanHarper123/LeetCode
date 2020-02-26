package leetCode.problems._242_Valid_Anagram;

import java.util.HashMap;

public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())
			return false;
		if(s.length()==0)
			return true;
		HashMap<Character, Integer> indexMap = new HashMap<>(s.length());
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Integer j = indexMap.get(c);
			if(j==null)
				indexMap.put(c, 1);
			else 
				indexMap.put(c, j+1);
			
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
			Integer j = indexMap.get(c);
			if(j==null)
				return false;
			else 
				indexMap.put(c, j-1);
		}
		for (Integer i : indexMap.values()) {
			if(i!=0)
				return false;
		}
		return true;
	}
}