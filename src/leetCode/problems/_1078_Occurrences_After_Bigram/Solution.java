package leetCode.problems._1078_Occurrences_After_Bigram;

import java.util.LinkedList;

public class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        LinkedList<String> res = new LinkedList<>();
        String[] arrays = text.split(" ");
        boolean firstEqual = false;
        for (int i = 0; i < arrays.length; i++) {
			if(second.equals(arrays[i])&&firstEqual&&i+1<arrays.length)
				res.add(arrays[i+1]);
			firstEqual = first.equals(arrays[i]);
		}
        String[] resA = new String[res.size()];
        int i = 0;
        for(String s:res) {
        	resA[i++] = s;
        }
        return resA;	
    }
}
