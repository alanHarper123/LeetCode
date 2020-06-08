package leetCode.problems._648_Replace_Words;

import java.util.List;
class Dictionary{
	boolean isWord = false;
	Dictionary[] nexChar = new Dictionary[26];
}
public class Solution {
	private Dictionary dictionary = new Dictionary();
    public String replaceWords(List<String> dict, String sentence) {
    	Dictionary runner;
    	for(String word:dict) {
    		runner = dictionary;
    		for (int i = 0; i < word.length(); i++) {
    			int index = word.charAt(i)-'a';
				if(runner.nexChar[index]==null)
					runner.nexChar[index] = new Dictionary();
				runner = runner.nexChar[index];
			}
    		runner.isWord = true;
    	}
    	StringBuilder result = new StringBuilder();
    	for (String successor : sentence.split(" ")) {
    		runner = dictionary;
			for (int i = 0; i < successor.length(); i++) {
				int index = successor.charAt(i)-'a';
				runner = runner.nexChar[index];
				if(runner==null) {
					result.append(successor.substring(i, successor.length()));
					break;
				}else if(runner.isWord) {
					break;
				}
				result.append(successor.charAt(i));
			}
			result.append(" ");
		}
    	if(result.length()>0)
    		result.deleteCharAt(result.length()-1);
    	return result.toString(); 
    }
}
