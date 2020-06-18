package leetCode.problems._693_Binary_Number_with_Alternating_Bits;

public class Solution {
    public boolean hasAlternatingBits(int n) {
        int keyBit = n&1;
        while (n>0) {
			if(keyBit!=(n&1))
				return false;
			keyBit = 1-keyBit;
			n>>=1;
		}
        return true;
    }
}
