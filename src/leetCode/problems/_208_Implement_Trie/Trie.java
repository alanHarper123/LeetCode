package leetCode.problems._208_Implement_Trie;

public class Trie {
	private CharBord charBord;
    /** Initialize your data structure here. */
    public Trie() {
        charBord = new CharBord();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	CharBord runner = charBord;
        for (int i = 0; i < word.length(); i++) {
			int ci = word.charAt(i)-'a';
			if(runner.chars[ci]==null)
				runner.chars[ci] = new CharBord();
			runner = runner.chars[ci];
		}
        runner.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	CharBord runner = charBord;
    	for (int i = 0; i < word.length(); i++) {
			int ci = word.charAt(i)-'a';
			if(runner.chars[ci]==null)
				return false;
			runner = runner.chars[ci];
		}
        return runner.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	CharBord runner = charBord;
    	for (int i = 0; i < prefix.length(); i++) {
			int ci = prefix.charAt(i)-'a';
			if(runner.chars[ci]==null)
				return false;
			runner = runner.chars[ci];
		}
    	return true;
    }
}

class CharBord{
	CharBord [] chars = new CharBord[26];
	boolean isWord;
}
