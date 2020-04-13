package leetCode.problems._387_First_Unique_Character_in_a_String;

public class Solution {
    public int firstUniqChar(String s) {
    	int[] occurC = new int[26];
    	int index=-1;
        for (int i = s.length()-1; i >=0; i--) {
        	occurC[s.charAt(i)-'a']++;
		}
        for (int i = s.length()-1; i >=0; i--) {
        	if(occurC[s.charAt(i)-'a']==1) {
        		index = i;
        	}
		}
        return index;
    }
}
