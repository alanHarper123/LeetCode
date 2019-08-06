package leetCode.problems._210_Course_Schedule_II;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

class Node{
	int val;
	int unloadC;
	HashSet<Node> pres;
	HashSet<Node> upper;
	public Node(int val) {
		this.val = val;
	}
}
public class Solution {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Node[] base = new Node[numCourses];
		int[] result = new int[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			int c = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(base[pre]==null)
				base[pre] = new Node(pre);
			else {
				if (base[c]!=null&&checkLoop(base[c], base[pre])) {
						return new int[0];
				}
			}
			if(base[c]==null) 
				base[c] = new Node(c);
			if(base[c].pres==null) 
				base[c].pres = new HashSet<>();

			if(base[pre].upper==null) 
				base[pre].upper = new HashSet<>();

			base[c].pres.add(base[pre]);
			base[pre].upper.add(base[c]);
		}
		int index = numCourses-1;
		LinkedList<Node> stack = new LinkedList<>();
		for (int i = 0; i < base.length; i++) {
			if(base[i]==null) {
				result[index--]=i;
			}else {
				if(base[i].upper==null) 
					stack.add(base[i]);
			}
		}
		while (!stack.isEmpty()) {
			Node newNode = stack.pop();

				result[index--]=newNode.val;
				if(newNode.pres!=null) {
					for (Iterator<Node> iterator = 
							newNode.pres.iterator(); iterator.hasNext();) {
						Node node = iterator.next();
						node.unloadC++;
						if(node.upper.size()==node.unloadC) {
							stack.add(node);
						}
					}
				}
			}
		
		return result;
	}
	private boolean checkLoop(Node code,Node pre) {
		if(code.val == pre.val)
			return true;
		HashSet<Node> coursePre = pre.pres;
		if(coursePre!=null) {
			for (Iterator<Node> iterator = 
					coursePre.iterator(); iterator.hasNext();) {
				Node newNode = iterator.next();
				if(code.val == newNode.val)
					return true;
				if(checkLoop(code, newNode))
					return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[][][] testData1 = {
				{{1,0},{2,0},{3,1},{3,2}},
				{{1,0},{0,3},{0,2},{3,2},{2,5},{4,5},{5,6},{2,4}},
				{{1,0},{2,0}},
		};
		int[] testData2 = {4,7,3};
		Solution solution = new Solution();
		for (int i = 0; i < testData2.length; i++) {
			System.out.println(Arrays.toString(solution.findOrder(testData2[i], testData1[i])));
		}
	}
}
