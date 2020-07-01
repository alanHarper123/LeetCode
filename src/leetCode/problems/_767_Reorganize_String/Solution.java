package leetCode.problems._767_Reorganize_String;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public String reorganizeString(String S) {
        int[][] charCounts = new int[26][2];
        int len = S.length(); 
        for (int i = 0; i < charCounts.length; i++) {
			charCounts[i][1] = i;
		}
        for (int i = 0; i < len; i++) {
			charCounts[S.charAt(i)-'a'][0]++;
		}
        Arrays.sort(charCounts,(ar1,ar2)->ar2[0]-ar1[0]);
        if(charCounts[0][0] >(len/2+len%2)) {
        	return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<LinkedList<Character>> sections = new LinkedList<>();
        Character c = (char)(charCounts[0][1]+'a');
        while (charCounts[0][0]>0) {
        	LinkedList<Character> section = new LinkedList<>();
        	section.add(c);
        	sections.add(section);
        	charCounts[0][0]--;
		}
        Iterator<LinkedList<Character>> iter = sections.listIterator();
        for (int i = 1; i < charCounts.length; i++) {
			if(charCounts[i][0]==0)
				break;
			else {
				Character newC = (char)(charCounts[i][1]+'a');
				while (charCounts[i][0]>0) {
					if(!iter.hasNext()) {
						iter = sections.listIterator(0);
					}
		        	LinkedList<Character> section = iter.next();
		        	section.add(newC);
		        	charCounts[i][0]--;
				}
			}
		}
        for (LinkedList<Character> section:sections) {
			Iterator<Character> sectionIter = section.iterator();
			while (sectionIter.hasNext()) {
				stringBuilder.append(sectionIter.next());
			}
		}
        
        return stringBuilder.toString();
    }
}
/*
767. Reorganize String
Medium

Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"

Example 2:

Input: S = "aaab"
Output: ""

Note:

    S will consist of lowercase letters and have length in range [1, 500].

 */
