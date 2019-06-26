package leetCode.problems.String_to_Integer_8;

import java.math.BigInteger;
import java.util.regex.*;

class Solution {
    public int myAtoi(String str) {
    	BigInteger result = new BigInteger("0");
    	Pattern pattern = Pattern.compile("^( +)?(-|\\+)?\\d+");
    	Matcher matcher = pattern.matcher(str);
    	if(matcher.find()) {
    		result = new BigInteger(matcher.group().trim());
    	}
    	if(result.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE)))>0) {
    		return Integer.MAX_VALUE;
    	}else if (result.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE)))<0) {
			return Integer.MIN_VALUE;
		}else {
			return result.intValue();
		}
    	
    }
    public static void main(String[] args) {
		System.out.println(new Solution().myAtoi("42"));
		System.out.println(new Solution().myAtoi("   -42"));
		System.out.println(new Solution().myAtoi("4193 with words"));
		System.out.println(new Solution().myAtoi("words and 987"));
		System.out.println(new Solution().myAtoi("-91283472332"));
	}
        
}