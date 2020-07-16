package leetCode.problems._Pow_x_n;

public class Solution {
    public double myPow(double x, int n) {
    	if(n<0) {
    		n = -n;
    		x = 1/x;
    	}	
    	double res = 1;
    	while (n!=0) {
			if((n&1)==1)
				res*=x;
			x*=x;
			n>>>=1;
		}
    	return res;
    }
}
