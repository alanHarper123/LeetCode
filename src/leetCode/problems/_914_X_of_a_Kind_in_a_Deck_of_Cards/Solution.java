package leetCode.problems._914_X_of_a_Kind_in_a_Deck_of_Cards;

import java.util.LinkedList;
import java.util.ListIterator;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] buckets = new int[10000];
        
        for(int card:deck) {
        	buckets[card]++;
        }
        LinkedList<Integer> divisors = new LinkedList<>();
        LinkedList<Integer> divisorsCp = new LinkedList<>();
        int n = buckets[deck[0]];
        int sqrtR = (int) Math.sqrt(n);
        for (int i = 2,cp; i <= sqrtR; i++) {
			if(n%i==0) {
				divisors.add(i);
				if((cp=n/i)!=i)
					divisorsCp.addFirst(cp);
			}
				
		}
        divisors.addAll(divisorsCp);
        if(n>1)
        	divisors.add(n);
        for (int i = 0,d; i < buckets.length; i++) {
        	 
			if((n=buckets[i])!=0) {
				ListIterator<Integer> iter = divisors.listIterator();
				while (iter.hasNext()) {
					d = iter.next();
					if(n%d!=0)
						iter.remove();
				}
				if(divisors.isEmpty())
	        		 return false;
			}	
		}
        
        return !divisors.isEmpty();
    }
    public static void main(String[] args) {
		System.out.println(new Solution().hasGroupsSizeX(new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,2,2,2,2,2,2,2,2,2,2,3,3,3,3,3,4,4,4,4,4,5,5,5,5,5
}));
	}
}
/*
914. X of a Kind in a Deck of Cards
Easy

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

    Each group has exactly X cards.
    All the cards in each group have the same integer.

 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].

Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false�
Explanation: No possible partition.

Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.

Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].

Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2].

 

Constraints:

    1 <= deck.length <= 10^4
    0 <= deck[i] < 10^4
 */
