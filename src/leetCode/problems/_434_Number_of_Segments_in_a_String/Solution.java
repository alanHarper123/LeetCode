package leetCode.problems._434_Number_of_Segments_in_a_String;

public class Solution {
    public int countSegments(String s) {
    	int count = 0;
    	for (int i = 0; i < s.length(); i++) {
    		while (i < s.length()&&Character.isWhitespace(s.charAt(i))) {
    			i++;
			}
			if (i < s.length()) {
				count++;
			}
			while (i < s.length()&&!Character.isWhitespace(s.charAt(i))) {
    			i++;
			}
		}
        return count;
    }
}
