package leetCode.problems._1048_Longest_String_Chain;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	int maxL;
    public int longestStrChain(String[] words) {
    	maxL = 0;
        Arrays.sort(words,(w1,w2)->w1.length()-w2.length());
        HashMap<String, Integer> dpMap = new HashMap<>();
        for(String word:words) {
        	StringBuilder stringBuilder = new StringBuilder(word);
        	int maxLen = 0;
        	for (int i = 0; i < stringBuilder.length(); i++) {
				char temp = stringBuilder.charAt(i);
				stringBuilder.setCharAt(i, '{');
				int preLen = dpMap.getOrDefault(stringBuilder.toString(), 0)+1;
				if(maxLen<preLen)
					maxLen=preLen;
				stringBuilder.setCharAt(i, temp);
			}
        	if(maxL<maxLen)
        		maxL = maxLen;
        	stringBuilder.append('{');
        	for (int i = stringBuilder.length()-1; i >= 0; i--) {
        		stringBuilder.setCharAt(i, '{');
				dpMap.put(new String(stringBuilder.toString()), maxLen);
				if(i!=0)
					stringBuilder.setCharAt(i, stringBuilder.charAt(i-1));
			}
        }
        return maxL;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().longestStrChain(new String[] {"a","b","ba","bca","bda","bdca"}));
	}
}
/*
1048. Longest String Chain
Medium

Given a list of words, each word consists of English lowercase letters.

Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere in word1 to make it equal to word2.  For example, "abc" is a predecessor of "abac".

A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of word_3, and so on.

Return the longest possible length of a word chain with words chosen from the given list of words.

 

Example 1:

Input: ["a","b","ba","bca","bda","bdca"]
Output: 4
Explanation: one of the longest word chain is "a","ba","bda","bdca".

 

Note:

    1 <= words.length <= 1000
    1 <= words[i].length <= 16
    words[i] only consists of English lowercase letters.
 */