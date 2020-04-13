package leetCode.problems._389_Find_the_Difference;

public class Solution {
    public char findTheDifference(String s, String t) {
        char result = 0;
        for (int i = 0; i < s.length(); i++) {
			result^=s.charAt(i);
		}
        for (int i = 0; i < t.length(); i++) {
			result^=s.charAt(i);
		}
        return result;
    }
}
