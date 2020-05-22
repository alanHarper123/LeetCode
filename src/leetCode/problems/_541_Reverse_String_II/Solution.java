package leetCode.problems._541_Reverse_String_II;

public class Solution {
    public String reverseStr(String s, int k) {
        int i = 0;
        boolean shouldReverse = true;
        StringBuilder reverseStrBuilder = new StringBuilder();
        while (i<s.length()) {
			if(shouldReverse) {
				int j = i+k-1;
				if(j>=s.length())
					j = s.length()-1;
				for (; j >=i; j--) {
					reverseStrBuilder.append(s.charAt(j));
				}
				i = i+k;
			}else {
				int end = i+k;
				if(end>=s.length())
					end = s.length()-1;
				for (; i<end; i++) {
					reverseStrBuilder.append(s.charAt(i));
				}
			}
			
			shouldReverse = !shouldReverse;
		}
        return reverseStrBuilder.toString();
    }
}
