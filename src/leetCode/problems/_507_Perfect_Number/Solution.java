package leetCode.problems._507_Perfect_Number;

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num<=1)
        	return false;
        int divisorSum = 1;
        int squareRoot = (int)Math.sqrt(num);
        for (int i = 2; i <= squareRoot; i++) {
        	
			if(num%i==0) {
				divisorSum+=i+num/i;
			}
				
		}
        return divisorSum==num;
    }
}
