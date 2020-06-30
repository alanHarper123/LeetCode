package leetCode.problems._756_Pyramid_Transition_Matrix;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Solution {
	private HashMap<String,LinkedList<Character>> baseToTops;
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        baseToTops = new HashMap<>();
        for (String allow : allowed) {
        	String base = allow.substring(0, 2);
        	LinkedList<Character> tops = baseToTops.get(base);
			if(tops==null) {
				tops = new LinkedList<>();
				baseToTops.put(base, tops);
			}
			tops.add(allow.charAt(2));
		}
        return pyramidTransitionUtil(bottom);
    }
    private boolean pyramidTransitionUtil(String base) {
    	if(base.length()==1)
    		return true;
    	StringBuilder stringBuilder = new StringBuilder();
    	LinkedList<LinkedList<Character>> nexLevel = new LinkedList<>();
    	for (int i = 1; i < base.length(); i++) {
			String baseSub = base.substring(i-1,i+1);
			LinkedList<Character> tops = baseToTops.get(baseSub);
			if(tops==null)
				return false;
			nexLevel.add(tops);
		}
    	if(backTrack(nexLevel, stringBuilder, 0))
    		return true;
    	return false;
    }
    private boolean backTrack(LinkedList<LinkedList<Character>> nexLevel,StringBuilder stringBuilder,int index) {
    	if(index==nexLevel.size()) {
    		if(pyramidTransitionUtil(stringBuilder.toString()))
    			return true;
    		return false;
    	}
    	Iterator<Character> topsIterator = nexLevel.get(index).iterator();
    	while (topsIterator.hasNext()) {
			stringBuilder.append(topsIterator.next());
			if(backTrack(nexLevel, stringBuilder, index+1))
				return true;
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
    	return false;	
    	
    }
}
