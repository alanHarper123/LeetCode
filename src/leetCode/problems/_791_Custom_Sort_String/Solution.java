package leetCode.problems._791_Custom_Sort_String;

import java.util.Arrays;

public class Solution {
	private int[] sortIndex;
	private int compare(char c1, char c2) {
		return sortIndex[c1-'a']-sortIndex[c2-'a'];
	}
    public String customSortString(String S, String T) {
        sortIndex = new int[26];
        for (int i = 0; i < sortIndex.length; i++) {
			sortIndex[i] = 26;
		}
        for (int i = 0; i < S.length(); i++) {
			sortIndex[S.charAt(i)-'a'] = i;
		}
        char[] chars = T.toCharArray();
        mergerSort(chars, 0, chars.length);
        return String.valueOf(chars);
    }
    private void mergerSort(char[] chars,int start,int end) {
    	if(end-start<=1)
    		return;
    	int mid = start+(end-start)/2;
    	mergerSort(chars, start, mid);
    	mergerSort(chars, mid, end);
    	char[] charsSub1 = Arrays.copyOfRange(chars, start, mid);
    	char[] charsSub2 = Arrays.copyOfRange(chars, mid, end);
    	int sub1i = 0,i=start,sub2i = 0;
    	while (sub1i<charsSub1.length&&sub2i<charsSub2.length) {
    		int compareR = compare(charsSub1[sub1i], charsSub2[sub2i]);
			if(compareR<=0) {
				chars[i++] = charsSub1[sub1i++];
			}else {
				chars[i++] = charsSub2[sub2i++];
			}
		}
    	while (sub1i<charsSub1.length) {
    		chars[i++] = charsSub1[sub1i++];
		}
    	while (sub2i<charsSub2.length) {
    		chars[i++] = charsSub2[sub2i++];
		}
    	return;
    }
}
/*
791. Custom Sort String
Medium

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.

 

Note:

    S has length at most 26, and no character is repeated in S.
    T has length at most 200.
    S and T consist of lowercase letters only.
 */
