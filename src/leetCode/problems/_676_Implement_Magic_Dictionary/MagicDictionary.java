package leetCode.problems._676_Implement_Magic_Dictionary;

class Dictionary{
	boolean isWord = false;
	Dictionary[] newChar = new Dictionary[26];
}
public class MagicDictionary {
	Dictionary dictionary;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        dictionary = new Dictionary();
        for(String word:dict) {
        	Dictionary runner = dictionary;
        	for (int i = 0; i < word.length(); i++) {
        		int index = word.charAt(i)-'a';
        		if(runner.newChar[index]==null)
        			runner.newChar[index] = new Dictionary();
				runner = runner.newChar[index];
			}
        	runner.isWord = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if(word==null)
        	return false;
        return searchUtil(word, 0, dictionary);
    }
    private boolean searchUtil(String word, int start,Dictionary runner) {
    	if(start==word.length())
    		return false;
    	int index = word.charAt(start)-'a';
    	if(runner.newChar[index]!=null) {
    		if(searchUtil(word, start+1, runner.newChar[index]))
    			return true;
    	}
    	for (int i = 0; i < 26; i++) {
			if(runner.newChar[i]==null||i==index)
				continue;
			else {
				if(checkIfSubWordExit(word, start+1, runner.newChar[i]))
					return true;
			}
		}
    	return false;
    }
    private boolean checkIfSubWordExit(String word, int start,Dictionary runner) {
    	for (int i = start; i < word.length(); i++) {
			runner = runner.newChar[word.charAt(i)-'a'];
			if(runner==null)
				return false;
		}
    	return runner.isWord;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */

/*
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:

Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False

Note:

    You may assume that all the inputs are consist of lowercase letters a-z.
    For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
    Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.

*/