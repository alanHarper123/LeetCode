package leetCode.problems._1202_Smallest_String_With_Swaps;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        char[] chars = s.toCharArray();
        LinkedList<Integer>[] neighbors = new LinkedList[chars.length];
        for (int i = 0; i < neighbors.length; i++) {
			neighbors[i] = new LinkedList<>();
		}
        for(List<Integer> list:pairs) {
        	int a = list.get(0);
        	int b = list.get(1);
        	neighbors[a].add(b);
        	neighbors[b].add(a);
        }
        boolean[] isVisited = new boolean[chars.length];
        int[] counts = new int[26];
        int[] indexs = new int[chars.length+1];
        for (int i = 0; i < neighbors.length; i++) {
			if(neighbors[i].size()!=0&&isVisited[i]==false) {
				indexs[0]=1;
				getTree(chars, i, isVisited, counts, indexs, neighbors);
				Arrays.sort(indexs, 1, indexs[0]);
				int j = 1;
				for (int k = 0; k < counts.length; k++) {
					int val = counts[k];
					while (val>0) {
						val--;
						chars[indexs[j++]] = (char) ('a'+k);
					}
					counts[k] = 0;
				}
			}
		}
        return new String(chars);
    }
    private void getTree(char[] chars,int start,boolean[] isVisited,
    		int[] counts,int[] indexs, LinkedList<Integer>[] neighbors) {
    	isVisited[start] = true;
    	counts[chars[start]-'a']++;
    	indexs[indexs[0]++] = start;
    	for(int neighbor:neighbors[start]) {
    		if(isVisited[neighbor]==false)
    			getTree(chars, neighbor, isVisited, counts, indexs, neighbors);
    	}
    }
}
