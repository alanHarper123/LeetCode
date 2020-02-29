package leetCode.problems._279_Perfect_Squares;

public class Solution {
	private int[] base;
    public int numSquares(int n) {
        base = new int[n];
        return numSquaresUtil(n);
    }
    private int numSquaresUtil(int n) {
    	if(base[n-1]!=0)
    		return base[n-1];
    	int sr = (int) Math.sqrt(n);
    	if(sr*sr==n) {
    		base[n-1] = 1;
    		return 1;
    	}
    	base[n-1] = Integer.MAX_VALUE;
    	for (int i = 0; i < n/2; i++) {
    		if(base[i]==0)
    			base[i] = numSquaresUtil(i+1);
    		if(base[n-2-i]==0)
    			base[n-2-i]=numSquaresUtil(n-i-1);
    		if(base[n-1]<base[i]+base[n-2-i])
    			base[n-1]=base[i]+base[n-2-i];
		}
    	return base[n-1];
    }
}
