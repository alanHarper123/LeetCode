package leetCode.problems._345_Reverse_Vowels_of_a_String;

public class Solution {
    public String reverseVowels(String s) {
    	StringBuilder sb = new StringBuilder(s);
    	int i = 0,j=s.length()-1;
    	for (; j>i;i++,j--) {
			while(i<j&&!isVowel(s.charAt(i)))
				i++;
			while (j>i&&!isVowel(s.charAt(j))) {
				j--;
			}
			if(j>i) {
				char temp = s.charAt(i);
				sb.setCharAt(i, sb.charAt(j));
				sb.setCharAt(j, temp);
			}else {
				break;
			}	
		}
    	return sb.toString();
    }
    boolean isVowel(char c) {
    	c = Character.toUpperCase(c);
    	if(c=='A'||c=='E'||c=='I'
    			||c=='O'||c=='U')
    		return true;
    	return false;
    		
    }
}
