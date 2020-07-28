package leetCode.problems._880_Decoded_String_at_Index;

import java.util.LinkedList;

public class Solution {
    public String decodeAtIndex(String S, int K) {
        Long len = (long) 0,lLen,sLen;
        LinkedList<Long> leftLens = new LinkedList<>();
        LinkedList<Long> sumLens = new LinkedList<>();
        LinkedList<Integer> rightBs = new LinkedList<>();
        for (int i = 0,c,m,d,index,rightB; i < S.length();) {
        	lLen = len;
        	sLen = (long) i;
			while (i+1<S.length()&&(c=S.charAt(i+1))>='a'&&c<='z') {
				i++;
			}
			sLen = i+1-sLen;
			len+=sLen;
			sLen = len;
			rightB = i;
			if(len>=K) {
				return String.valueOf(S.charAt((int) (rightB-(len-K))));
			}
			m=1;
			i++;
			while (i<S.length()&&(d=S.charAt(i))>='2'&&d<='9') {
				m*=d-'0';
				i++;
			}
			len*=m;
			if(len>=K) {
				index = (int) (K%sLen);
				if(index!=0&&index<=lLen) {
					do {
						lLen = leftLens.pollLast();
						sLen = sumLens.pollLast();
						index = (int) (index%sLen);
						rightB = rightBs.pollLast();
					} while (index!=0&&index<=lLen);
				}
				if(index==0)
					return String.valueOf(S.charAt((int) (rightB)));
				else if(index>lLen) {
					return String.valueOf(S.charAt((int) (rightB-(sLen-index))));
				}
			}
			leftLens.add(lLen);
			sumLens.add(sLen);
			rightBs.add(rightB);
		}
        return "";
    }
    public static void main(String[] args) {
		System.out.println(new Solution().decodeAtIndex("ha22", 5));
	}
}
/*
880. Decoded String at Index
Medium

An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:

    If the character read is a letter, that letter is written onto the tape.
    If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.

Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.

 

Example 1:

Input: S = "leet2code3", K = 10
Output: "o"
Explanation: 
The decoded string is "leetleetcodeleetleetcodeleetleetcode".
The 10th letter in the string is "o".

Example 2:

Input: S = "ha22", K = 5
Output: "h"
Explanation: 
The decoded string is "hahahaha".  The 5th letter is "h".

Example 3:

Input: S = "a2345678999999999999999", K = 1
Output: "a"
Explanation: 
The decoded string is "a" repeated 8301530446056247680 times.  The 1st letter is "a".

 

Constraints:

    2 <= S.length <= 100
    S will only contain lowercase letters and digits 2 through 9.
    S starts with a letter.
    1 <= K <= 10^9
    It's guaranteed that K is less than or equal to the length of the decoded string.
    The decoded string is guaranteed to have less than 2^63 letters.
 */