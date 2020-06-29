package leetCode.problems._752_Open_the_Lock;

import java.util.HashSet;
import java.util.LinkedList;

public class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> visitedSet = new HashSet<>();
        for (String deadend:deadends) {
			visitedSet.add(deadend);
		}
        String startP = "0000";
        if(visitedSet.contains(startP)||visitedSet.contains(target))
        	return -1;
        LinkedList<String> frontiers = new LinkedList<>();
        frontiers.add(startP);
        visitedSet.add(startP);
        int moveCount = 0;
        while (!frontiers.isEmpty()) {
        	moveCount++;
			int width = frontiers.size();
			while (width>0) {
				width--;
				char[] chars = frontiers.pollFirst().toCharArray();
				for (int i = 0; i < chars.length; i++) {
					char temp = chars[i];
					for (int j = -1; j < 2; j+=2) {
						char c = (char)(chars[i]+j);
						if(c>'9')
							c='0';
						if(c<'0')
							c = '9';
						chars[i] = c;
						String newPosition = String.valueOf(chars);
						chars[i] = temp;
						if(visitedSet.contains(newPosition)) {
							continue;
						}
						if(target.equals(newPosition))
							return moveCount;
						frontiers.add(newPosition);
						visitedSet.add(newPosition);
					}
				}
			}
		}
        return -1;
    }
    public static void main(String[] args) {
		String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
		Solution solution = new Solution();
		System.out.println(solution.openLock(deadends, "0202"));
	}
}
