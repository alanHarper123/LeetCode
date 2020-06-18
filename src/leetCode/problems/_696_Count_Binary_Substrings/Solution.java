package leetCode.problems._696_Count_Binary_Substrings;

public class Solution {
    public int countBinarySubstrings(String s) {
    	int totalN = 0;
    	int preC = 0;
        for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int count = 1;
			while (i+1<s.length()&&s.charAt(i+1)==c) {
				i++;
				count++;
			}
			totalN+=Math.min(preC, count);
			preC = count;
		}
        return totalN;
    }
}
