package leetCode.problems._Reverse_Words_in_a_String;

public class Solution {
    public String reverseWords(String s) {
    	s = s.strip();
        StringBuilder res = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = words.length-1; i >=0 ; i--) {
        	if(words[i].length()==0)
        		continue;
			res.append(words[i]);
			if(i!=0)
				res.append(" ");
		}
        return res.toString();
    }
}
