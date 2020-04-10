package leetCode.problems._151_reverseWords;

public class Solution {

    public String reverseWords(String s) {
    	if(s==null)
    		return null;
    	StringBuilder sentence = new StringBuilder();
    	int count = s.length()-1;
    	int letterCount = 0;
    	while (count>=0) {
    		letterCount = 0;
			while (count>=0&&s.charAt(count)==' ') {
				count--;
			}
			while (count>=0&&s.charAt(count)!=' ') {
				letterCount++;
				count--;
			}
			int i=1;
			while (i<=letterCount) {
				sentence.append(s.charAt(count+i++));
			}
			if(letterCount>0) {
				letterCount=0;
				sentence.append(' ');
			}	
		}
    	if(sentence.length()>1)
    		sentence.deleteCharAt(sentence.length()-1);
    	return sentence.toString();
    }
}
