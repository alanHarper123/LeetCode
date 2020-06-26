package leetCode.problems._743_Network_Delay_Time;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Node{
	int id;
	LinkedList<Node> neighbors = new LinkedList<>();
	LinkedList<Integer> delays = new LinkedList<>();
	public Node(int id) {
		this.id = id;
	}
}
public class Solution {
	private Comparator<int[]> timingComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
	};
    public int networkDelayTime(int[][] times, int N, int K) {
        Node[] allNodes = new Node[N+1];
        for(int[] time:times) {
        	Node u = allNodes[time[0]];
        	Node v = allNodes[time[1]];
        	if(u==null) {
        		u = new Node(time[0]);
        		allNodes[time[0]] = u ;
        	}
        	if(v==null) {
        		v = new Node(time[1]);
        		allNodes[time[1]] = v ;
        	}
        	u.neighbors.add(v);
        	u.delays.add(time[2]);
        }
        if(allNodes[K]==null)
        	return -1;
        boolean[] isNodeVisited = new boolean[N+1];
        int timeC = 0;
        PriorityQueue<int[]> bfs_frontiers = new PriorityQueue<>(timingComparator);
        bfs_frontiers.add(new int[] {0,K});
        while (!bfs_frontiers.isEmpty()) {
			int[] frontier = bfs_frontiers.poll();
			if(isNodeVisited[frontier[1]])
				continue;
			isNodeVisited[frontier[1]] = true;
			if(frontier[0]>timeC)
				timeC = frontier[0];
			Node frontierNode = allNodes[frontier[1]];
			Iterator<Node> neighborIter = frontierNode.neighbors.iterator();
			Iterator<Integer> delaysIter = frontierNode.delays.iterator();
			while (neighborIter.hasNext()) {
				Node neighbor = neighborIter.next();
				int delay = delaysIter.next()+frontier[0];
				if(!isNodeVisited[neighbor.id]) {
					bfs_frontiers.add(new int[] {delay,neighbor.id});
				}
			}
		}
        for (int i = 1; i < isNodeVisited.length; i++) {
			if(!isNodeVisited[i])
				return -1;
		}
        return timeC;
    }
    public static void main(String[] args) {
		int[][] times = new int[][] {{1,2,1},{2,3,2},{1,3,4}};
		Solution solution = new Solution();
		System.out.println(solution.networkDelayTime(times, 3, 1));
	}
}
