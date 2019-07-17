package leetCode.problems._120_Triangle;

import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0)
        	return 0;
        List<Integer> preR;
        List<Integer> currentR=triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
        	preR = triangle.get(i-1);
        	currentR = triangle.get(i);
        	for (int j = 0; j < currentR.size(); j++) {
				if(j==0)
					currentR.set(j, currentR.get(j)+preR.get(j));
				else if (j==currentR.size()-1) 
					currentR.set(j, currentR.get(j)+preR.get(j-1));
				else 
					currentR.set(j, currentR.get(j)
							+Math.min(preR.get(j-1), preR.get(j)));
			}
		}
        int min = currentR.get(0);
        for (int i = 1; i < currentR.size(); i++) {
			if(currentR.get(i)<min)
				min=currentR.get(i);
		}
        return min;
    }
}
