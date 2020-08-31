package leetCode.problems._1002_Find_Common_Characters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> commonChars(String[] A) {
        int[] counts = new int[26];
        Arrays.fill(counts, Integer.MAX_VALUE);
        int[] countsT = new int[26];
        for (String s : A) {
        	Arrays.fill(countsT, 0);
			for (int i = 0; i < s.length(); i++) {
				countsT[s.charAt(i)-'a']++;
			}
			for (int i = 0; i < countsT.length; i++) {
				counts[i] = Math.min(counts[i], countsT[i]);
			}
		}
        LinkedList<String> res = new LinkedList<>();
        for (int i = 0,c; i < counts.length; i++) {
			c=counts[i];
			String chari = String.valueOf((char)('a'+i));
			while (c>0) {
				c--;
				res.add(chari);
			}
		}
        return res;
    }
}
