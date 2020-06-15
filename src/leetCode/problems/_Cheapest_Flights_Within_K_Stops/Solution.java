package leetCode.problems._Cheapest_Flights_Within_K_Stops;

import java.util.Iterator;
import java.util.LinkedList;

class Node{
	int cityN;
	Integer minCost;
	LinkedList<Node> dests = new LinkedList<>();
	LinkedList<Integer> prices = new LinkedList<>();
	public Node(int cityN) {
		this.cityN = cityN;
	}
}
public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Node[] cities = new Node[n];
        for (int[] flight:flights) {
        	Node startC = cities[flight[0]];
        	if(startC==null) {
        		startC = new Node(flight[0]);
        		cities[flight[0]] = startC;
        	}
        	Node endC = cities[flight[1]];
        	if(endC == null) {
        		endC = new Node(flight[1]);
        		cities[flight[1]] = endC;
        	}
        	startC.dests.add(endC);
        	startC.prices.add(flight[2]);
		}
        K++;
        if(K<=0||cities[src]==null||cities[dst]==null)
        	return -1;
        LinkedList<Integer> frontiers = new LinkedList<>();
        frontiers.add(0);
        frontiers.add(src);
        while (K>0&&!frontiers.isEmpty()) {
			K--;
			int width = frontiers.size()/2;
			while (width>0) {
				width--;
				Node frontier = cities[frontiers.pollLast()];
				int minCost = frontiers.pollLast();
				Iterator<Node> destsIter = frontier.dests.iterator();
				Iterator<Integer> prices = frontier.prices.iterator();
				while (destsIter.hasNext()) {
					Node destNode = destsIter.next();
					int price = prices.next();
					if(destNode.minCost==null||minCost+price<destNode.minCost) {
						destNode.minCost = minCost+price;
						frontiers.addFirst(destNode.cityN);
						frontiers.addFirst(minCost+price);
						
					}
				}
			}
		}
        Node end = cities[dst];
        if(end.minCost==null)
        	return -1;
        return end.minCost;
    }
    public static void main(String[] args) {
		int[][] flights = new int[][] {{0,1,1},{0,2,5},{1,2,1},{2,3,1}};
		Solution solution = new Solution();
		System.out.println(solution.findCheapestPrice(4, flights, 0, 3, 1));
	}
}
