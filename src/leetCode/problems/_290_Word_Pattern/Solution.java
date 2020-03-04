package leetCode.problems._290_Word_Pattern;

import java.util.HashSet;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] base = new String[26];
        HashSet<String> baseSet = new HashSet<>(26);
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (int i = 0, j; i <= str.length(); i++) {
			if(i <str.length()&&str.charAt(i)!=' ')
				sb.append(str.charAt(i));
			else {
				if(k==pattern.length())
					return false;
				j = pattern.charAt(k++)-'a';
				if(base[j]==null) {
					base[j] = sb.toString();
					if(!baseSet.add(sb.toString()))
						return false;
				}
				else if(!base[j].equals(sb.toString())){
					return false;
				}
				sb.delete(0, sb.length());
			}
		}
        if(k!=pattern.length())
        	return false;
        return true;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.wordPattern("abba","dog cat cat dog"));
	}
}
