package leetCode.problems._953_Verifying_an_Alien_Dictionary;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
    	int[] reOrder = new int[26];
    	for (int i = 0; i < order.length(); i++) {
			reOrder[order.charAt(i)-'a'] = i;
		}
        for (int i = 1; i < words.length; i++) {
			if(!isSmaller(words[i-1], words[i], reOrder))
				return false;
		}
        return true;
    }
    private boolean isSmaller(String s1, String s2,int[] reOrder) {
    	int len = s1.length();
    	if (len>s2.length()) {
			len = s2.length();
		}
    	
    	for (int i = 0,di; i < len; i++) {
    		di = reOrder[s1.charAt(i)-'a']-reOrder[s2.charAt(i)-'a'];
			if(di>0)
				return false;
			else if(di<0)
				return true;
		}
    	if(len<s1.length())
    		return false;
    	return true;
    }
}
