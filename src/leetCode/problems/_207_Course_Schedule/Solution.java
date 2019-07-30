package leetCode.problems._207_Course_Schedule;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class Node{
	int val;
	LinkedList<Node> pres;
	public Node(int val) {
		this.val = val;
	}
}
public class Solution {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		HashMap<Integer, Node> base = new HashMap<>();
		for (int i = 0; i < prerequisites.length; i++) {
			int c = prerequisites[i][0];
			int pre = prerequisites[i][1];
			Node course = base.get(c);
			Node preCourse = base.get(pre);
			if(course==null) {
				course = new Node(c);
				base.put(c, course);

			}

			if(preCourse==null) {
				preCourse = new Node(pre);
				base.put(pre, preCourse);

			}else {
				if (checkLoop(course, preCourse))
					return false;
			}
			if(course.pres==null)
				course.pres = new LinkedList<>();
			course.pres.add(preCourse);
		}
		return true;	
	}
	private boolean checkLoop(Node code,Node pre) {
		if(code.val == pre.val)
			return true;
		LinkedList<Node> coursePre = pre.pres;
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
}
