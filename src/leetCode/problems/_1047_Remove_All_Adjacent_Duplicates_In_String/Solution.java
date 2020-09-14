package leetCode.problems._1047_Remove_All_Adjacent_Duplicates_In_String;

import java.util.LinkedList;

public class Solution {
    public String removeDuplicates(String S) {
        LinkedList<Character> sequence = new LinkedList<>();
        for (char val:S.toCharArray()) {
			if(!sequence.isEmpty()&&sequence.peekLast()==val)
				sequence.pollLast();
			else 
				sequence.add(val);
		}
        StringBuilder res = new StringBuilder();
        for(Character c:sequence)
        	res.append(c);
        return res.toString();
    }
}
