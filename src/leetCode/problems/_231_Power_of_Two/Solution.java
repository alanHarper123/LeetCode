package leetCode.problems._231_Power_of_Two;

class Solution {
    public boolean isPowerOfTwo(int n) {
    	boolean bitSet = false;
        while (n!=0) {
        	if(bitSet)
        		return false;
			if((n&1)==1)
				bitSet = true;
			n>>=1;
		}
        return bitSet;
    }
}
