package leetCode.problems.Divide_Two_Integers_29;


public class Solution {
    public int divide(int dividend, int divisor) {
    	boolean signed = false;
    	int reminder = 0;
    	if(divisor<0) {
    		if(divisor==Integer.MIN_VALUE) {
    			return dividend==Integer.MIN_VALUE?1:0;
    		}
    		signed=!signed;
    		divisor = -divisor;
    	}
    	if (dividend < 0) {
    		signed=!signed;
    		if(dividend==Integer.MIN_VALUE) {
    			dividend = Integer.MAX_VALUE;
    			reminder = 1;
    		}else {
    			dividend = -dividend;
    		}
    	}
        int quotient=0;

        while (dividend>=divisor) {
        	int k=1, temp=divisor, temp2=temp;
        	while (true) {
        		temp <<= 1;
        		if(dividend<temp||temp<0) {
        			break;
        		}
        		k<<=1;
        		temp2=temp;
        	}
        	quotient+=k;
        	dividend -= temp2;
        }
		

        if(reminder==1&&dividend+1>=divisor) {
        	if(quotient==Integer.MAX_VALUE) {
        		return signed?Integer.MIN_VALUE:Integer.MAX_VALUE;
        	}
        	quotient++;
        }
        return signed?(-quotient):quotient;
    }
}
