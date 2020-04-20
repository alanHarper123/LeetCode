package leetCode.problems._412_Fizz_Buzz;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        LinkedList<String> words = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
			String si = "";
			if(i%3==0)
				si+="Fizz";
			if (i%5==0)
				si+="Buzz";
			if(si.length()==0)
				words.add(String.valueOf(i));
			else
				words.add(si);
		}
        return words;
    }
}
