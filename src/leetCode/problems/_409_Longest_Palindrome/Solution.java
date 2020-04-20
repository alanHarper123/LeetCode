package leetCode.problems._409_Longest_Palindrome;

public class Solution {
    public int longestPalindrome(String s) {
    	int[] lcCs = new int[26];
    	int[] ucCs = new int[26];
    	for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c>='a') {
				ucCs[c-'a']++;
			}else {
				lcCs[c-'A']++;
			}
		}
    	int sum=0;
    	for (int i = 0; i < ucCs.length; i++) {
			sum+=(lcCs[i]/2)*2;
			sum+=(ucCs[i]/2)*2;	
		}
    	if(sum<s.length())
    		sum++;
    	return sum; 
    }
}
