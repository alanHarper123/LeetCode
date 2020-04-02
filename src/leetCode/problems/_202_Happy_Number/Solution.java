package leetCode.problems._202_Happy_Number;

import java.util.HashSet;

public class Solution {
	private HashSet<Integer> base;
    public boolean isHappy(int n) {
        base = new HashSet<>();
        return isHappyUtil(n);
        		
    }
    private boolean isHappyUtil(int n) {
    	if(n==1)
        	return true;
        else if(!base.add(n)){
        	return false;
        }
        int SqureSum = 0;
        for (char c:String.valueOf(n).toCharArray()) {
        	SqureSum+=Math.pow(c-'0', 2);
		}
        return isHappyUtil(SqureSum);
    }
}
