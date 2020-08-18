package leetCode.problems._948_Bag_of_Tokens;

import java.util.Arrays;

public class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int j = tokens.length-1;
        int maxP = 0;
        for (int i=0,point=0; i<=j; i++) {
			if(P<tokens[i]) {
				if(point==0)
					break;
				else {
					point--;
					P+=tokens[j--];
					P-=tokens[i];
					if(P<0)
						break;
				}
			}else 
				P-=tokens[i];
			point++;
			if(point>maxP)
				maxP = point;
		}
        return maxP;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().bagOfTokensScore(new int[] {68,85,34,25,60}, 44));
	}
}
/*
948. Bag of Tokens
Medium

You have an initial power P, an initial score of 0 points, and a bag of tokens.

Each token can be used at most once, has a value token[i], and has potentially two ways to use it.

    If we have at least token[i] power, we may play the token face up, losing token[i] power, and gaining 1 point.
    If we have at least 1 point, we may play the token face down, gaining token[i] power, and losing 1 point.

Return the largest number of points we can have after playing any number of tokens.

 

Example 1:

Input: tokens = [100], P = 50
Output: 0

Example 2:

Input: tokens = [100,200], P = 150
Output: 1

Example 3:

Input: tokens = [100,200,300,400], P = 200
Output: 2

 

Note:

    tokens.length <= 1000
    0 <= tokens[i] < 10000
    0 <= P < 10000
 */