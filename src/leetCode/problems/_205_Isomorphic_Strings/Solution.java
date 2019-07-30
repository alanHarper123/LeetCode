package leetCode.problems._205_Isomorphic_Strings;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> base = new HashMap<>();
        HashSet<Character> vals = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
			Character a = s.charAt(i);
			Character b = t.charAt(i);
			Character baseB = base.get(a);
			if(baseB==null) {
				base.put(a, b);
				if(!vals.add(b))
					return false;
			}else if(baseB!=b) {
				return false;
			}
		}
        return true;
    }
}
