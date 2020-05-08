package leetCode.problems._482_License_Key_Formatting;

import leetCode.problems._404_Sum_of_Left_Leaves.solution;

public class Solution {
    public String licenseKeyFormatting(String S, int K) {
        int i = S.length()-1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i>=0) {
			int c = K;
			while (c>0&&i>=0) {
				if(S.charAt(i--)!='-') {
					c--;
					stringBuilder.append(Character.toUpperCase(S.charAt(i+1)));
				}
			}
			if(i>=0)
				stringBuilder.append('-');
		}
        if(stringBuilder.length()>0&&
        		stringBuilder.charAt(stringBuilder.length()-1)=='-')
        	stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.reverse().toString();
    }
}
