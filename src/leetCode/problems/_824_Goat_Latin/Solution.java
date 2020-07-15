package leetCode.problems._824_Goat_Latin;

public class Solution {
	public String toGoatLatin(String S) {
		StringBuilder res = new StringBuilder();
		String[] words = S.split(" ");
		int count = 1;
		for (String word:words) {
			char lc = word.charAt(0);
			char lcLow = Character.toLowerCase(lc);
			switch (lcLow) {
			case 'a':
			case 'e':
			case 'i':
			case 'o':
			case 'u':
				res.append(word);
				break;
			default:
				res.append(word.substring(1));
				res.append(lc);
				break;
			}
			res.append("ma");
			for (int i = 0; i < count; i++) {
				res.append('a');
			}
			res.append(" ");
			count++;
		}
		if(res.length()!=0)
			res.deleteCharAt(res.length()-1);
		return res.toString();
	}
}
/*
824. Goat Latin
Easy

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

    If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
    For example, the word 'apple' becomes 'applema'.

    If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
    For example, the word "goat" becomes "oatgma".

    Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
    For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.

Return the final sentence representing the conversion from S to Goat Latin. 



Example 1:

Input: "I speak Goat Latin"
Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"

Example 2:

Input: "The quick brown fox jumped over the lazy dog"
Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"



Notes:

    S contains only uppercase, lowercase and spaces. Exactly one space between each word.
    1 <= S.length <= 150.
 */