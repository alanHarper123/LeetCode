package leetCode.problems._575_Distribute_Candies;

import java.util.HashSet;

public class Solution {
    public int distributeCandies(int[] candies) {
        int maxCandyC  = candies.length/2;
        HashSet<Integer> candyKinds = new HashSet<>(maxCandyC);
        for (int candy:candies) {
			if(candyKinds.add(candy)&&candyKinds.size()==maxCandyC)
				return maxCandyC;
		}
        return candyKinds.size();
    }
}
