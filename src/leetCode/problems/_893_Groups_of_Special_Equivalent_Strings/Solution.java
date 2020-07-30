package leetCode.problems._893_Groups_of_Special_Equivalent_Strings;

import java.util.HashSet;

public class Solution {
    public int numSpecialEquivGroups(String[] A) {
        HashSet<String> hashSet = new HashSet<>();
        int[] count = new int[26];
        StringBuilder stringBuilder;
        for (String word:A) {
			stringBuilder = new StringBuilder();
			for (int i = 0; i < word.length(); i+=2) {
				count[word.charAt(i)-'a']++;
			}
			for (int i = 0,val; i < count.length; i++) {
				val = count[i];
				if(val>0) {
					char c = (char)(i+'a');
					while (val>0) {
						stringBuilder.append(c);
						val--;
					}
					count[i] = 0;
				}
			}
			stringBuilder.append("}");
			for (int i = 1; i < word.length(); i+=2) {
				count[word.charAt(i)-'a']++;
			}
			for (int i = 0,val; i < count.length; i++) {
				val = count[i];
				if(val>0) {
					char c = (char)(i+'a');
					while (val>0) {
						stringBuilder.append(c);
						val--;
					}
					count[i] = 0;
				}
			}
			hashSet.add(stringBuilder.toString());
		}
        return hashSet.size();
    }
}
