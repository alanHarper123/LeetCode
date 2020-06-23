package leetCode.problems._720_Longest_Word_in_Dictionary;

import java.util.LinkedList;

class Dictionary{
	boolean isWord = false;
	Dictionary[] nextChar = new Dictionary[26];
}
public class Solution {
	private Dictionary dictionary;
	private String maxWord;
    public String longestWord(String[] words) {
        dictionary = new Dictionary();
        dictionary.isWord = true;
        maxWord="";  
        for (String word:words) {
        	Dictionary runner = dictionary;
        	for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i)-'a';
				if(runner.nextChar[index]==null) {
					runner.nextChar[index] = new Dictionary();
				}
				runner = runner.nextChar[index];
			}
        	runner.isWord = true;
		}
        LinkedList<Character> prefix = new LinkedList<>();
        longestWordUtil(dictionary, prefix);
        return maxWord;
    }
    private void longestWordUtil(Dictionary dictionary,LinkedList<Character> prefix) {
    	
    	for (int i = 0; i < dictionary.nextChar.length; i++) {
			if(dictionary.nextChar[i]!=null&&dictionary.nextChar[i].isWord) {
				prefix.add((char)('a'+i));
				longestWordUtil(dictionary.nextChar[i], prefix);
				prefix.pollLast();
			}	
		}
    	if(prefix.size()>maxWord.length())
    		maxWord = convertListTOString(prefix);
    }
    private String convertListTOString(LinkedList<Character> prefix) {
    	StringBuilder stringBuilder = new StringBuilder();
    	for (Character c:prefix) {
			stringBuilder.append(c);
		}
    	return stringBuilder.toString();
    }
}
