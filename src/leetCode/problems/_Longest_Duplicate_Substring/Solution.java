package leetCode.problems._Longest_Duplicate_Substring;

public class Solution {
    public String longestDupSubstring(String S) {
    	if(S==null)
    		return "";
        int maxL = 0;
        int maxIndex = 0;
        for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			int searchDup = i;
			while((searchDup=S.indexOf(c, searchDup+1))>0) {
				int di = i+1, ds = searchDup+1;
				int len = 1;
				while (ds<S.length()&&S.charAt(di++)==S.charAt(ds++)) {
					len++;
				}
				if(len>maxL) {
					maxL = len;
					maxIndex = i;
				}
			}
		}
        return S.substring(maxIndex, maxIndex+maxL);
    }
}
