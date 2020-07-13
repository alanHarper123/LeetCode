package leetCode.problems._820_Short_Encoding_of_Words;

import java.util.Arrays;

public class Solution {
	class Trie{
		Trie[] nextChar = new Trie[26];
	}
	private Trie postfix;
	public int minimumLengthEncoding(String[] words) {
		postfix = new Trie();
		Arrays.sort(words, (w1,w2)->w2.length()-w1.length());
		int count = 0;
		boolean isPostfix;
		for (String word:words) {
			isPostfix = true;
			Trie runner = postfix;
			for (int j = word.length()-1; j >=0 ; j--) {
				int index = word.charAt(j) - 'a';
				if(runner.nextChar[index]==null) {
					runner.nextChar[index] = new Trie();
					isPostfix = false;
				}
				runner = runner.nextChar[index];
			}
			if(!isPostfix)
				count+=word.length()+1;
		}
		return count;
	}
}
