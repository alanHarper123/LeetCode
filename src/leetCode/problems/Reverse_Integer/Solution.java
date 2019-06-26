package leetCode.problems.Reverse_Integer;

class Solution {
    public int reverse(int x) {
    	boolean isNegative = false;
    	if(x<0) {
    		x=-x;
    		isNegative = true;
    	}
        String string = String.valueOf(x);
        
        char[] chars = string.toCharArray();
        char[] reverseChars = new char[chars.length];
        for(int i = chars.length-1, j=0;i>-1;i--,j++ ) {
        	reverseChars[j]=chars[i];
        }
        int result = 0;
        try {
			result = Integer.valueOf(new String(reverseChars));

		} catch (Exception e) {
			return 0;
		}
        if (isNegative) {
			return -result;
		}
        return result;
    }
}
