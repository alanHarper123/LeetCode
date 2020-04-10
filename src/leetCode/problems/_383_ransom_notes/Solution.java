package leetCode.problems._383_ransom_notes;

import java.util.HashMap;

public class Solution {
	HashMap<Character, Integer> charCs;
    public boolean canConstruct(String ransomNote, String magazine) {
    	if(ransomNote.length()>magazine.length())
    		return false;
    	charCs = new HashMap<>(26);
    	
    	Integer c;
    	for (int i = 0; i < ransomNote.length(); i++) {
			c = charCs.get(ransomNote.charAt(i));
			if(c==null)
				c=0;
			charCs.put(ransomNote.charAt(i), c+1);
		}
    	for (int i = 0; i < magazine.length(); i++) {
    		Character cr = magazine.charAt(i);
    		c = charCs.get(cr); 
			if(c!=null) {
				if(c==1) {
					charCs.remove(cr);
					if(charCs.isEmpty())
						return true;
				}
				else
					charCs.put(cr, c-1);
			}
		}
    	return charCs.isEmpty();
    }
}
