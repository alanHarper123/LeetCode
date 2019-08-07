package leetCode.problems._211_Add_and_Search_Word;

import java.util.Iterator;
import java.util.LinkedList;


class CharBord{
	CharBord [] chars;
	boolean isWord;
}
public class WordDictionary {
	private CharBord charBord;
    /** Initialize your data structure here. */
    public WordDictionary() {
    	charBord = new CharBord();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	CharBord runner = charBord;
        for (int i = 0; i < word.length(); i++) {
			int ci = word.charAt(i)-'a';
			if(runner.chars==null) {
				runner.chars = new CharBord[26];
			}
			if(runner.chars[ci]==null)
				runner.chars[ci] = new CharBord();
			runner = runner.chars[ci];
		}
        runner.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	LinkedList<CharBord> candidates = new LinkedList<>();
    	candidates.add(charBord);
    	for (int i = 0; i < word.length(); i++) {
    		if(candidates.isEmpty())
    			return false;
    		int count = 0;
    		while (count!=candidates.size()) {
    			CharBord charBord = candidates.poll();
                if(charBord.chars==null)
    				continue;
    			if(word.charAt(i)=='.') {
					for (int j = 0; j < charBord.chars.length; j++) {
						if(charBord.chars[j]!=null) {
							candidates.add(charBord.chars[j]);
							count++;
						}	
					}
				}else {
					int ci = word.charAt(i)-'a';
					if(charBord.chars[ci]!=null) {
						count++;
						candidates.add(charBord.chars[ci]);
					}						
				}
			}
		}
    	for (Iterator<CharBord> iterator = 
    			candidates.iterator(); iterator.hasNext();) {
			CharBord charBord =  iterator.next();
			if(charBord.isWord)
				return true;
		}
    	return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
