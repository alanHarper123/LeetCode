package leetCode.problems._433_Minimum_Genetic_Mutation;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
	private final static char[] genes = new char[] {'A','C','G','T'};
	public int minMutation(String start, String end, String[] bank) {
		if(start==null|end==null||start.length()!=end.length())
			return -1;
		HashSet<String> visitedSet = new HashSet<>(bank.length+1);
		HashSet<String> validSet = new HashSet<>(bank.length);
		LinkedList<String> bfs_frontiers = new LinkedList<>();
		for (int i = 0; i < bank.length; i++) {
			validSet.add(bank[i]);
		}
		bfs_frontiers.add(start);
		visitedSet.add(start);
		int count = 1;
		while (!bfs_frontiers.isEmpty()) {
			int breathC = bfs_frontiers.size();
			for (int i = 0; i < breathC; i++) {
				char[] chars = bfs_frontiers.pollFirst().toCharArray();
				for (int j = 0; j < chars.length; j++) {
					char c = chars[j];
					for(char g:genes) {
						if(c!=g) {
							chars[j]=g;
							String s = new String(chars);

							if(!visitedSet.contains(s)&&validSet.contains(s)) {
								if(s.equals(end))
									return count;
								bfs_frontiers.add(s);
								visitedSet.add(s);
							}
						}

					}
					chars[j]=c;

				}
			}
			count++;
		}
		return -1;
	}
}
