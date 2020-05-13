package leetCode.problems._500_Keyboard_Row;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	private static char[][] keyboard = new char[][] {{'q','w','e','r','t','y','u','i','o','p'},
		{'a','s','d','f','g','h','j','k','l'},{'z','x','c','v','b','n','m'}};
	private static HashMap<Character, Integer> letterToRowC = new HashMap<>();
	static {
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[i].length; j++) {
				letterToRowC.put(keyboard[i][j], i);
			}
		}
	}
    public String[] findWords(String[] words) {
        LinkedList<String> validWords = new LinkedList<>();
        loop1:for (String word:words) {
			if(word.length()<=1) {
				validWords.add(word);
				continue;
			}
			int rowc = letterToRowC.get(Character.toLowerCase(word.charAt(0)));
			for (int i = 1; i < word.length(); i++) {
				if(letterToRowC.get(Character.toLowerCase(word.charAt(i)))!=rowc)
					continue loop1;
			}
			validWords.add(word);
		}
        String[] results = new String[validWords.size()];
        for (int i = 0; i < results.length; i++) {
			results[i] = validWords.pollFirst();
		}
        return results;
    }
}
