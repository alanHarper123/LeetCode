package leetCode.problems._819_Most_Common_Word;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;


public class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("[\\s,?;\\.\\!]");
        HashSet<String> bannedWords = new HashSet<>();
        for (String bannedWord:banned) {
			bannedWords.add(bannedWord);
		}
        HashMap<String, Integer> wordToCounts = new HashMap<>();
        for (String word:words) {
        	if(word.length()==0)
        		continue;
        	word  = word.toLowerCase();
			int index = word.indexOf('\'');
			if(index!=-1) {
				word = word.substring(0, index);
			}
			if(!bannedWords.contains(word)) {
				Integer count = wordToCounts.get(word);
				if(count==null)
					count=0;
				wordToCounts.put(word, count+1);
			}
		}
        String mostFrWord = "";
        int maxCount = 0;
        for(Entry<String, Integer> entry:wordToCounts.entrySet()) {
        	if(entry.getValue()>maxCount) {
        		maxCount = entry.getValue();
        		mostFrWord = entry.getKey();
        	}
        }
        return mostFrWord;
        
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] {"hit"}));
	}
}
