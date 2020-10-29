package leetCode.problems._1208_Get_Equal_Substrings_Within_Budget;

public class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int[] difs = new int[s.length()];
        for (int i = 0; i < difs.length; i++) {
			difs[i] = Math.abs(s.charAt(i)-t.charAt(i));
		}
        int maxLen = 0;
        int left = 0,sum=0;
        for (int i = 0; i < difs.length; i++) {
			sum+=difs[i];
			while (sum>maxCost) {
				sum-=difs[left++];
			}
			if(i-left+1>maxLen)
				maxLen = i-left+1;
		}
        return maxLen;
    }
}
