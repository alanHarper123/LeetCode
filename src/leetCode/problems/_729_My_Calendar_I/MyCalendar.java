package leetCode.problems._729_My_Calendar_I;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class MyCalendar {
	private ArrayList<int[]> intervals = new ArrayList<>(1000);
	private Comparator<int[]> intervalComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
	};
    public MyCalendar() {
    }
    
    public boolean book(int start, int end) {
    	int[] interval = new int[] {start,end};
        int index = Collections.binarySearch(intervals, interval,intervalComparator);
        if(index>=0)
        	return false;
        index = -(index+1);
        if(index!=0&&intervals.get(index-1)[1]>start) {
        	return false;
        }
        if(index!=intervals.size()&&intervals.get(index)[0]<end) {
        	return false;
        }
        intervals.add(index,interval);
        return true;
    }
}
class MyCalendar002 {

	private TreeSet<int[]> intervals = new TreeSet<>((a1,a2)->a1[0]-a2[0]);
    public MyCalendar002() {
    }
    
    public boolean book(int start, int end) {
    	int[] interval = new int[] {start,end};
        if(intervals.contains(interval))
        	return false;
        int[] pre = intervals.lower(interval);
        if(pre!=null&&pre[1]>start)
        	return false;
        int[] next = intervals.higher(interval);
        if(next!=null&&next[0]<end)
        	return false;
        intervals.add(interval);
        return true;
    }
}
