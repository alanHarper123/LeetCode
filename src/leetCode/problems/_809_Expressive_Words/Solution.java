package leetCode.problems._809_Expressive_Words;

import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int expressiveWords(String S, String[] words) {
    	LinkedList<Character> chars = new LinkedList<>();
    	LinkedList<Integer> lens = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
			chars.add(S.charAt(i));
			int iTemp = i;
			while (i+1<S.length()&&S.charAt(i+1)==S.charAt(i)) {
				i++;
			}
			lens.add(i-iTemp+1);
		}
        int count = 0;
        loop1:for (String word:words) {
        	Iterator<Character> iter = chars.listIterator();
        	Iterator<Integer> lensIter = lens.listIterator();
			for (int i = 0; i < word.length(); i++) {
				if(!iter.hasNext())
					continue loop1;
				char c = iter.next();
				if(word.charAt(i)!=c)
					continue loop1;
				int iTemp = i;
				while (i+1<word.length()&&word.charAt(i+1)==c) {
					i++;
				}
				int len = i-iTemp+1;
				int lenOrig = lensIter.next();
				if(!(lenOrig==len||(lenOrig>len&&lenOrig>2)))
					continue loop1;
			}
			if(iter.hasNext())
				continue;
			count++;
		}
        return count;
    }
    public static void main(String[] args) {
		String S = "heeellooo";
		String[] words = new String[] {"hello", "hi", "helo"};
		Solution solution = new Solution();
		System.out.println(solution.expressiveWords(S, words));
		System.out.println(0x44>>>3);
	}
}
