package leetCode.problems._846_Hand_of_Straights;

import java.util.Arrays;

public class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
    	if(W==1)
    		return true;
        if(hand.length%W!=0)
        	return false;
        Arrays.sort(hand);
        int[] fr = new int[hand.length];
        Integer pre = null;
        int sum = 0;
        for (int i = 0,j=0; i < hand.length; i++) {
        	int count = i;
			while (i+1<hand.length&&hand[i+1]==hand[i]) {
				i++;
			}
			count = i-count+1;
        	if(pre!=null) {
        		if(hand[i]==pre+1) {
        			if(count-sum<0)
        				return false;
        			fr[j++] = count-sum;
        			sum+=count-sum;
        			if(j-W>=0) {
        				sum -= fr[j-W];
        			}
        		}else {
        			if(sum!=0)
        				return false;
        			sum = count;
        			j=0;
        			fr[j++] = count;
        		}
        	}else {
        		sum+=count;
        		fr[j++] = count;
        	}
			pre = hand[i];
		}
        return sum==0;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isNStraightHand(new int[] {1,2,3,6,2,3,4,7,8}, 3));
	}
}
/*
846. Hand of Straights
Medium

Alice has a hand of cards, given as an array of integers.

Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.

Return true if and only if she can.

 

Example 1:

Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].

Example 2:

Input: hand = [1,2,3,4,5], W = 4
Output: false
Explanation: Alice's hand can't be rearranged into groups of 4.

 

Constraints:

    1 <= hand.length <= 10000
    0 <= hand[i] <= 10^9
    1 <= W <= hand.length

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 */