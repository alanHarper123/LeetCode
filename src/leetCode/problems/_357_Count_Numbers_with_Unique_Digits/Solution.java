package leetCode.problems._357_Count_Numbers_with_Unique_Digits;

public class Solution {
    public int countNumbersWithUniqueDigits(int n) {

        int result = 0;
        int i = 2;
        int iter = 9;
        if(n>=1)
        	result+=iter;
        int limit = n;
        if(limit>10)
        	limit=10;
        //combination of n integer of 0-9 (9*9*8*7*...)
        while (i<=limit) {
        	iter*=(11-i);
        	result += iter;
        	i++;
		}
        result++;
        return result;
    }
}
