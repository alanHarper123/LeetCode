package leetCode.problems._917_Reverse_Only_Letters;

public class Solution {
    public String reverseOnlyLetters(String S) {
        char[] chars = S.toCharArray();
        char temp;
        for (int i = 0,j=chars.length-1; i < j; i++,j--) {
			while (i<j&&!Character.isLetter(chars[i])) {
				i++;
			}
			while (i<j&&!Character.isLetter(chars[j])) {
				j--;
			}
			if(i<j) {
				temp = chars[i];
				chars[i] = chars[j];
				chars[j] = temp;
			}
		}
        return String.valueOf(chars);
    }
}
