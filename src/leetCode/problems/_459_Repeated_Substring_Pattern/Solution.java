package leetCode.problems._459_Repeated_Substring_Pattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
    	if(s.length()==1)
    		return false;
    	int[] charCounts = new int[26];
    	int[] subCharCounts = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			charCounts[s.charAt(i)-'a']++;
		}
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length()-1; i >=stringBuilder.length(); i--) {
        	subCharCounts[s.charAt(i)-'a']++;
			stringBuilder.append(s.charAt(i));
			if(s.charAt(i)==s.charAt(0)&&s.length()%stringBuilder.length()==0
					&&compareCharCounts(charCounts, subCharCounts,s.length()/stringBuilder.length())
					&&compareString(s, stringBuilder, i)) {
				return true;
			}
		}
        return false;
    }

    private boolean compareCharCounts(int[] charCounts,int[] subCharCounts, int count) {

    	for (int i = 0; i < subCharCounts.length; i++) {
			if(charCounts[i]!=count*subCharCounts[i])
				return false;
		}
    	return true;
    }
    private boolean compareString(String s,StringBuilder stringBuilder,int end) {
    	for (int j = 0; j < end; j++) {
			if(s.charAt(j)!=stringBuilder.charAt(stringBuilder.length()-1-j%stringBuilder.length()))
				return false;
		}
    	return true;
    }
}
