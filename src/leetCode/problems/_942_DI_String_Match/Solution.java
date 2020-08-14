package leetCode.problems._942_DI_String_Match;

public class Solution {
    public int[] diStringMatch(String S) {
        int[] res = new int[S.length()+1];
        for (int i = 0; i < res.length; i++) {
			res[i] = i;
		}
        for (int i = 0,itemp; i < S.length(); i++) {
			if(S.charAt(i)=='D') {
				itemp = i;
				while (i+1<S.length()&&S.charAt(i+1)=='D') {
					i++;
				}
				reverse(res, itemp, i+1);
				i++;
			}
		}
        return res;
    }
    private void reverse(int[] res, int start,int end) {
    	int temp;
    	while (start<end) {
    		temp = res[end];
    		res[end--] = start;
    		res[start++] = temp;
		}
    }
}
