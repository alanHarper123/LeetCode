package leetCode.problems._841_Keys_and_Rooms;

import java.util.List;

public class Solution {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int[] parents = new int[rooms.size()];
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		dfs(rooms, rooms.get(0), parents, 0);
		for (int i = 0; i < parents.length; i++) {
			if(parents[i]!=0)
				return false;
		}
		return true;
	}
	private void dfs(List<List<Integer>> rooms,
			List<Integer> room,int[] parents, int index) {
		for(int rN:room) {
			if(findParent(parents, rN)!=0) {
				parents[rN] = 0;
				dfs(rooms, rooms.get(rN), parents, rN);
			}
		}
		
	}
	private int findParent(int[] parents, int i) {
		if(parents[i]==i)
			return i;
		parents[i] = findParent(parents, parents[i]);
		return parents[i];
	}
}
