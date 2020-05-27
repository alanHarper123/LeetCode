package leetCode.problems._557_Reverse_Words_in_a_String_III;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder wordsBuilder = new StringBuilder();
        for (String word:words) {
        	wordsBuilder.append(" ");
			for (int i = word.length()-1; i >=0 ; i--) {
				wordsBuilder.append(word.charAt(i));
			}
		}
        if(wordsBuilder.length()!=0)
        	wordsBuilder.deleteCharAt(0);
        return wordsBuilder.toString();
    }
}
