package leetCode.problems._884_Uncommon_Words_from_Two_Sentences;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public String[] uncommonFromSentences(String A, String B) {
    	HashSet<String> setA = new HashSet<>();
    	HashSet<String> dupSet = new HashSet<>();
    	LinkedList<String> uncommons = new LinkedList<>();
    	
    	for(String word:A.split(" ")) {
    		if(dupSet.add(word)) {
    			setA.add(word);
    		}else {
    			setA.remove(word);
    		}
    	}
    	for(String word:B.split(" ")) {
    		if(dupSet.add(word)) {
    			setA.add(word);
    		}else {
    			setA.remove(word);
    		}
    	}
    	uncommons.addAll(setA);
    	return uncommons.toArray(new String[uncommons.size()]);
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().uncommonFromSentences("apple apple","banana")));
	}
}
