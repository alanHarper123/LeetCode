package leetCode.problems.Implement_strStr_28;

public class Solution {
    public int strStr(String haystack, String needle) {
      if(needle.length()==0) {
    	  return 0;
      }
      loop1:  for (int i = 0; i <= haystack.length()-needle.length(); i++) {
			for (int j = 0; j < needle.length(); j++) {
				if(haystack.charAt(i+j)!=needle.charAt(j)) {
					continue loop1;
				}
			}
			return i;
		}
        return -1;
    }
}
