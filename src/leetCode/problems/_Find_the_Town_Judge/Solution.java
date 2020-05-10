package leetCode.problems._Find_the_Town_Judge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class Solution {
    public int findJudge(int N, int[][] trust) {
    	if(N==1&&trust.length==0)
    		return 1;
        HashSet<Integer> nonIudges = new HashSet<>();
        HashMap<Integer,Integer> possibleJudges = new HashMap<>();
        for (int i = 0; i < trust.length; i++) {
			nonIudges.add(trust[i][0]);
			possibleJudges.remove(trust[i][0]);
			if(!nonIudges.contains(trust[i][1])) {
				Integer count = possibleJudges.getOrDefault(trust[i][1], 0);
				possibleJudges.put(trust[i][1], count+1);
			}	
		}
        for(Entry<Integer, Integer> entry:possibleJudges.entrySet()) {
        	if(entry.getValue()>=N-1)
        		return entry.getKey();
        }
        return -1;

    }
}
