package leetCode.problems._1177_Can_Make_Palindrome_from_Substring;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        LinkedList<Boolean> res = new LinkedList<>();
        int[][] dp = new int[s.length()+1][26];
        for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < 26; j++) {
				dp[i+1][j] = dp[i][j];
			}
			dp[i+1][s.charAt(i)-'a']++;
		}
        for(int[] query:queries) {
        	int oddC = 0;
        	int[] startS = dp[query[0]], endS = dp[query[1]+1];
        	for (int j = 0; j < 26; j++) {
				if(((endS[j]-startS[j])&1)==1)
					oddC++;
			}
        	res.add(oddC/2<=query[2]);
        }
        return res;
    }
}
