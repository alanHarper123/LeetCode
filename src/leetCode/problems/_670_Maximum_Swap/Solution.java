package leetCode.problems._670_Maximum_Swap;

import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public int maximumSwap(int num) {
    	char[] digits = String.valueOf(num).toCharArray();
    	char[] maxDigits = Arrays.copyOf(digits, digits.length);
    	Arrays.sort(maxDigits);
    	int i = 0;
    	int difMin = -1;
    	for (; i < digits.length; i++) {
			if(digits[i]<maxDigits[digits.length-1-i]) {
				difMin = maxDigits[digits.length-1-i];
		    	break;
			}
		}
    	if(difMin!=-1) {
    		for (int j = digits.length-1; j >i ; j--) {
				if(digits[j]==difMin) {
					char temp = digits[i];
					digits[i] = digits[j];
					digits[j] = temp;
					break;
				}
			}
    	}
    	return new Integer(String.valueOf(digits));
    }
}
