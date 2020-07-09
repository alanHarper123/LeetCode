package leetCode.problems._804_Unique_Morse_Code_Words;

import java.util.HashSet;

public class Solution {
	private static String[] morseCode = new String[] {".-","-...",
			"-.-.","-..",".","..-.","--.","....","..",".---","-.-",
			".-..","--","-.","---",".--.","--.-",".-.","...","-",
			"..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> uniqueMorse = new HashSet<>();
        StringBuilder stringBuilder;
        for (String word:words) {
        	stringBuilder = new StringBuilder();
        	for (int i = 0; i < word.length(); i++) {
				stringBuilder.append(morseCode[word.charAt(i)-'a']);
			}
        	uniqueMorse.add(stringBuilder.toString());
		}
        return uniqueMorse.size();
    }
}
