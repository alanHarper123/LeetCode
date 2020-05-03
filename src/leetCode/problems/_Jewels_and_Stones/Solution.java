package leetCode.problems._Jewels_and_Stones;

public class Solution {
    public int numJewelsInStones(String J, String S) {
    	if(J==null||S==null||J.length()==0||S.length()==0)
    		return 0;
        boolean[] isJew = new boolean['z'-'A'+1];
        for (int i = 0; i < J.length(); i++) {
			isJew[J.charAt(i)-'A'] = true;
		}
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
			if(isJew[S.charAt(i)-'A'])
				count++;
		}
        return count;
    }
}
