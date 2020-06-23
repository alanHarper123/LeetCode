package leetCode.problems._720_Longest_Word_in_Dictionary;

import java.util.Arrays;

class Dictionary{
	boolean isWord = false;
	Dictionary[] nextChar = new Dictionary[26];
}
public class Solution {
	private Dictionary dictionary;
    public String longestWord(String[] words) {
        dictionary = new Dictionary();
        dictionary.isWord = true;
        Arrays.sort(words);
        String maxWord="";
        
        for (String word:words) {
        	Dictionary runner = dictionary;
        	for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i)-'a';
				if(runner.nextChar[index]==null) {
					if(i==word.length()-1) {
						runner.nextChar[index] = new Dictionary();
						runner.nextChar[index].isWord = true;
						if(word.length()>maxWord.length()) {
							maxWord = word;
						}
					}else 
						break;
				}else {
					runner = runner.nextChar[index];
				}
			}
		}
        return maxWord;
    }
}
