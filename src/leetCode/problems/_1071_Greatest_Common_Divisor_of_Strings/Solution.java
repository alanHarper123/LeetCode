package leetCode.problems._1071_Greatest_Common_Divisor_of_Strings;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
    	if(str1.length()>str2.length()) {
    		String temp = str1;
    		str1 = str2;
    		str2 = temp;
    	}		
        LinkedList<Integer> sdivisors = new LinkedList<>();
        LinkedList<Integer> ldivisors = new LinkedList<>();
        int root = (int) Math.sqrt(str1.length());
        for (int i = 1; i <= root; i++) {
			if(str1.length()%i==0) {
				sdivisors.add(i);
				ldivisors.addFirst(str1.length()/i);
			}
		}
        if(sdivisors.peekLast()==ldivisors.peekFirst())
        	ldivisors.pollFirst();
        sdivisors.addAll(ldivisors);
        ListIterator<Integer> iter = sdivisors.listIterator();
        while (iter.hasNext()) {
			if(str2.length()%iter.next()!=0)
				iter.remove();
		}
        Iterator<Integer> iterD = sdivisors.descendingIterator();
        while (iterD.hasNext()) {
			int len = iterD.next();
			if(judge(str1, str1,len)&&judge(str1,str2, len))
				return str1.substring(0, len);
		}
        return "";
    }
    private boolean judge(String str1, String str2, int len) {
    	int c = str2.length()/len;
    	for (int i = 0; i < len; i++) {
    		char val = str1.charAt(i);
			for (int j = 0; j < c; j++) {
				if(str2.charAt(j*len+i)!=val)
					return false;
			}
		}
    	return true;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().gcdOfStrings("ABCDEF",
				"ABC"

));
	}
}
/*
1071. Greatest Common Divisor of Strings
Easy

For two strings s and t, we say "t divides s" if and only if s = t + ... + t  (t concatenated with itself 1 or more times)

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""

Example 4:

Input: str1 = "ABCDEF", str2 = "ABC"
Output: ""

 

Constraints:

    1 <= str1.length <= 1000
    1 <= str2.length <= 1000
    str1 and str2 consist of English uppercase letters.
 */