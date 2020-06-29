package leetCode.problems._744_Find_Smallest_Letter_Greater_Than_Target;

import java.util.Arrays;

public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index = Arrays.binarySearch(letters, (char)(target+1));
        if(index<0) {
        	index = -(index+1);
        	if(index==letters.length)
        		index = 0;
        }
        return letters[index];
    }
}
