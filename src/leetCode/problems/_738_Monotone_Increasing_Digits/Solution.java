package leetCode.problems._738_Monotone_Increasing_Digits;

import java.util.Arrays;

public class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        int keyIndex = 0;
        for (int i = 1; i < digits.length; i++) {
			if(digits[i]>digits[i-1])
				keyIndex = i;
			else if(digits[i]<digits[i-1]) {
				digits[keyIndex] = (char) (digits[keyIndex]-1);
				for (int j = keyIndex+1; j < digits.length; j++) {
					digits[j] = '9';
				}
				break;
			}
		}
        return Integer.valueOf(new String(digits));
    }
}
