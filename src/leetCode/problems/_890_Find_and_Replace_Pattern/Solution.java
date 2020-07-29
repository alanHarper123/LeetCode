package leetCode.problems._890_Find_and_Replace_Pattern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
    	
    	int[] counts = new int[26];
    	for (int i = 0; i < pattern.length(); i++) {
			counts[pattern.charAt(i)-'a']++;
		}
    	int[] w_counts = new int[26];
    	int[] w_index = new int[26];
    	boolean[] isVisited = new boolean[26];
        LinkedList<String> res = new LinkedList<>();
        loop1:for (String word:words) {
        	for (int i = w_counts.length-1; i >=0; i--) {
        		w_counts[i] = counts[i];
			}
        	Arrays.fill(isVisited, false);
        	Arrays.fill(w_index, -1);
			for (int i = 0,k,m; i < word.length(); i++) {
				k = word.charAt(i)-'a';
				if(w_index[k]==-1) {
					m = pattern.charAt(i)-'a';
					if(isVisited[m])
						continue loop1;
					w_index[k] = m;
					isVisited[m] = true;
				}
				if(w_counts[w_index[k]]==0)
					continue loop1;
				w_counts[w_index[k]]--;
					
			}
			res.add(word);
		}
        return res;
    }
}
/*
890. Find and Replace Pattern
Medium

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.

 

Note:

    1 <= words.length <= 50
    1 <= pattern.length = words[i].length <= 20
 */
