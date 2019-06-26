package leetCode.problems.ZigZag_Conversion_6;

import java.util.Iterator;
import java.util.LinkedList;

class Solution {
    public String convert(String s, int numRows) {
    	if(s.length()==0||numRows==1) return s;
    	LinkedList<Integer> seeds = new LinkedList<>();
    	int i = 0;
    	for(i=1; i*(numRows-1)<s.length()-1;i+=2) {
    		seeds.add(i*(numRows-1));

    	}
    	if((i*(numRows-1)-(s.length()-1))<=numRows-1) {
    		seeds.add(i*(numRows-1));
    	}

    	StringBuffer stringBuffer = new StringBuffer();
    	for(int j=numRows-1; j>-1; j--) {
    		for (Iterator iterator = seeds.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				if(integer-j<s.length()) {
					stringBuffer.append(s.charAt(integer-j));
				}
				
				if(integer+j<s.length()&&j!=numRows-1&&j!=0) {
					stringBuffer.append(s.charAt(integer+j));
				}
				
			}
    	}
        return stringBuffer.toString();
    }
    public static void main(String[] args) {
    	System.out.println(new Solution().convert("AB", 1));
	}
}
