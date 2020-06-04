package leetCode.problems._638_Shopping_Offers;

import java.util.LinkedList;
import java.util.List;


class MinExpense{
	int val;
	MinExpense[] nextDimensions = new MinExpense[7];
}

public class Solution {
	private  MinExpense minExpenses;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	minExpenses = new MinExpense();
    	return shoppingOffersUtil(price, special, needs);
        
    }
    private int shoppingOffersUtil(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
    	MinExpense runner = minExpenses;
    	for (int need:needs) {
			if(runner.nextDimensions[need]!=null) {
				runner = runner.nextDimensions[need];
			}else {
				runner = null;
				break;
			}
		}
    	if(runner==null) {
    		int minCost = Integer.MAX_VALUE;
        	int cost=0;
        	for (int i = 0; i < needs.size(); i++) {
    			cost+= needs.get(i)*price.get(i);
    		}
        	if(cost<minCost)
    			minCost = cost;
        	loop1:for (List<Integer> offer:special) {
        		LinkedList<Integer> newNeeds = new LinkedList<>();
        		for (int i = 0; i < needs.size(); i++) {
        			int newNeed = needs.get(i)-offer.get(i);
    				if(newNeed<0)
    					continue loop1;
    				else 
    					newNeeds.add(newNeed);	
    			}
    			cost = offer.get(offer.size()-1)+shoppingOffersUtil(price, special, newNeeds);
    			if(cost<minCost)
    				minCost = cost;
        	}
        	runner = minExpenses;
        	for (int need:needs) {
    			if(runner.nextDimensions[need]!=null) {
    				runner = runner.nextDimensions[need];
    			}else {
    				runner.nextDimensions[need]=new MinExpense();
    				runner = runner.nextDimensions[need];
    			}
    		}
        	runner.val = minCost;
    	}
    	return runner.val;

    }
}
