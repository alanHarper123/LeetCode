package leetCode.problems._179_Largest_Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class StringCompare implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		int n = s1.length()+s2.length()-1;
		char c1, c2;
		for (int i = 0; i < n; i++) {
			if(i<s1.length())
				c1=s1.charAt(i);
			else 
				c1=s2.charAt(i-s1.length());
			if(i<s2.length())
				c2=s2.charAt(i);
			else 
				c2=s1.charAt(i-s2.length());
			if(c1>c2)
				return -1;
			else if(c1<c2)
				return 1;
		}
		return 0;
	}
	
}
public class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<String> base = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
			base.add(String.valueOf(nums[i]));
		}
        Collections.sort(base, new StringCompare());
        if(base.size()==0||Integer.valueOf(base.get(0))==0)
        	return "0";
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> iterator = 
        		base.iterator(); iterator.hasNext();) {
			sb.append(iterator.next());
		}
        return sb.toString();
    }
}
