package leetCode.problems._855_Exam_Room;

import java.util.HashMap;
import java.util.PriorityQueue;

public class ExamRoom {
	class Interval {
		final int start;
		final int end;
		final int maxDis;
		public Interval(int start,int maxDis,int end) {
			this.start = start;
			this.maxDis = maxDis;
			this.end = end;
		}
	}
	PriorityQueue<Interval> queue = new PriorityQueue<>((in1,in2)->{
		if(in1.maxDis==in2.maxDis)
			return in1.start-in2.start;
		return in2.maxDis-in1.maxDis;
	});
	int N;
	HashMap<Integer, Interval> startToInerval = new HashMap<>();
	HashMap<Integer, Interval> endToInerval = new HashMap<>();
	public ExamRoom(int N) {
		this.N = N;
		putNewInterval(-2*(N-1), 2*(N-1));
	}

	public int seat() {
		Interval interval = queue.poll();
		int mid = interval.start+interval.maxDis;
		if(mid!=0) {
			if(interval.start<0) {
				putNewInterval(-mid, mid);
			}else {
				putNewInterval(interval.start, mid);
			}
		}
		if(mid!=this.N-1) {
			int end = interval.end;
			if(end>this.N-1) {
				putNewInterval(mid,2*(this.N-1)-mid);
			}else {
				putNewInterval(mid,end);
			}
		}
		return mid;
	}
	private void putNewInterval(int start, int end) {
		//use (end/2-start/2) instead of (end - start)/2 to avoid overflow;
		int maxDis;
		if(start<0) {
			maxDis = end/2-start/2;
			if((end&1)==1&(start&1)==1)
				maxDis+=1;
		}else {
			maxDis = (end-start)/2;
		}
		Interval interval = new Interval(start,maxDis,end);
		queue.add(interval);
		startToInerval.put(start, interval);
		endToInerval.put(end, interval);
	}
	public void leave(int p) {
		Interval left = endToInerval.remove(p);
		Interval right = startToInerval.remove(p);
		queue.remove(left);
		queue.remove(right);
		int newStart;
		if(left==null||left.start<0) {
			newStart = right==null||right.end>N-1?(-2*(N-1)):-right.end;
		}else{
			newStart = left.start;
		}
		int newEnd;
		if(right==null||right.end>N-1) {
			newEnd = left==null||left.start<0?2*(this.N-1):2*(this.N-1)-left.start;
		}else {
			newEnd = right.end;
		}
		putNewInterval(newStart,newEnd);
	}
	public static void main(String[] args) {
		ExamRoom examRoom = new ExamRoom(10);
		examRoom.seat();
		examRoom.seat();
		examRoom.seat();
		examRoom.leave(0);
		examRoom.leave(4);
		System.out.println(examRoom.seat());
	}
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
/*
855. Exam Room
Medium

In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.  If there are multiple such seats, they sit in the seat with the lowest number.  (Also, if no one is in the room, then the student sits at seat number 0.)

Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in, and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.  It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.

 

Example 1:

Input: ["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[],[4],[]]
Output: [null,0,9,4,2,null,5]
Explanation:
ExamRoom(10) -> null
seat() -> 0, no one is in the room, then the student sits at seat number 0.
seat() -> 9, the student sits at the last seat number 9.
seat() -> 4, the student sits at the last seat number 4.
seat() -> 2, the student sits at the last seat number 2.
leave(4) -> null
seat() -> 5, the student sits at the last seat number 5​
Note:
    1 <= N <= 10^9
    ExamRoom.seat() and ExamRoom.leave() will be called at most 10^4 times across all test cases.
    Calls to ExamRoom.leave(p) are guaranteed to have a student currently sitting in seat number p.
 */