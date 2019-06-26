package leetCode.problems.Longest_Common_Prefix_14;

class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length==0) {
    		return "";
    	}
    	int minLength = Integer.MAX_VALUE;
    	for (String s : strs) 
			if(minLength>s.length()) minLength = s.length();
    	int i = 0;
    	
    	while (true) {
    		if (i== minLength) return strs[0].substring(0, i);
    		Character c = strs[0].charAt(i);
    		for(int j=1; j<strs.length; j++) {
    			if(c!=strs[j].charAt(i))
    				return strs[0].substring(0, i);
    		}
			i++;
		}
    }
}
