package leetCode.problems._443_String_Compression;

public class Solution {
    public int compress(char[] chars) {
    	if(chars==null||chars.length==0)
    		return 0;
    	
        int counti = 1;
        char unique = chars[0];
        int uniqueIndex = 0;
        for (int i = 1; i < chars.length; i++) {
			while (i<chars.length&&unique==chars[i]) {
				counti++;
				i++;
			}
			chars[uniqueIndex++] = unique;
			if(counti>1) {
				String countS = String.valueOf(counti);
				for (int j = 0; j < countS.length(); j++) {
					chars[uniqueIndex++] = countS.charAt(j);
				}
			}
			counti = 0;
			if(i<chars.length) {
				unique=chars[i];
				counti=1;
			}
		}
        if(counti!=0)
        	chars[uniqueIndex++] = unique;
        return uniqueIndex;
    }
}
