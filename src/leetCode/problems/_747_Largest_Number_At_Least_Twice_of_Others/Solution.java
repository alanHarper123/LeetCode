package leetCode.problems._747_Largest_Number_At_Least_Twice_of_Others;

public class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
    	int[] keyWord = new int[26];
    	int charCount = 0;
    	for (int i = 0; i < licensePlate.length(); i++) {
			char c = licensePlate.charAt(i);
			c = Character.toLowerCase(c);
			if(c>='a'&&c<='z') {
				keyWord[c-'a']++;
				charCount++;
			}	
		}
    	String result = null;
        loop1:for (String word:words) {
        	if(charCount>word.length()||
        			(result!=null&&result.length()<=word.length()))
        		continue;
			int[] newWord = new int[26];
			for (int i = 0; i < word.length(); i++) {
				int index = word.charAt(i)-'a';
				newWord[index]++;
			}
			for (int i = 0; i < keyWord.length; i++) {
				if(keyWord[i]!=0&&keyWord[i]>newWord[i])
					continue loop1;
			}
			result = word;
			
		}
        return result;
    }
}
