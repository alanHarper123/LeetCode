package leetCode.problems._875_Koko_Eating_Bananas;

public class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int pile:piles) {
			if(pile>max)
				max = pile;
		}
        if(H==piles.length)
        	return max;
        int min = 1;
        int sum = 0;
        int minQ = Integer.MAX_VALUE;
        while (min<=max) {
        	int mid = (max+min)/2;
        	sum = 0;
        	for (int pile:piles) {
        		sum+=pile/mid;
    			if(pile%mid!=0)
    				sum+=1;
    		}
        	if(sum>H)
        		min = mid+1;
        	else if(sum<=H) {
        		max = mid-1;
        		minQ = Math.min(minQ, mid);
        	}	
		}
        return minQ;
    }
}
/*
875. Koko Eating Bananas
Medium

Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.

 

Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4

Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30

Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23

 

Constraints:

    1 <= piles.length <= 10^4
    piles.length <= H <= 10^9
    1 <= piles[i] <= 10^9 
 */
