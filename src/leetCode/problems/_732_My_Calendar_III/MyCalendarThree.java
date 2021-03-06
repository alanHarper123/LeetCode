package leetCode.problems._732_My_Calendar_III;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyCalendarThree {
	private ArrayList<ArrayList<int[]>> bookings = new ArrayList<>();
	int maxIntersect = 0;
	private Comparator<int[]> bookingsComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
	};
    public MyCalendarThree() {
        
    }
    public int book(int start, int end) {
    	bookUtil(new int[] {start,end},bookings, 0);
    	return bookings.size();
    }
    private void bookUtil(int[] booking,ArrayList<ArrayList<int[]>> bookings,int level) {
    	if(level == bookings.size()) {
    		bookings.add(new ArrayList<>());
    		bookings.get(bookings.size()-1).add(booking);
    	}else {
    		ArrayList<int[]> kBookings = bookings.get(level);
    		int index = Collections.binarySearch(kBookings,booking,bookingsComparator);
    		if(index<0)
    			index = -(index+1);
    		boolean isMerged = false;
        	if(index!=0&&kBookings.get(index-1)[1]>booking[0]) {
        		bookUtil(new int[] {booking[0], Math.min(kBookings.get(index-1)[1], booking[1])},
        				bookings, level+1);
        		kBookings.get(index-1)[1] =  Math.max(kBookings.get(index-1)[1], booking[1]);
            	isMerged = true;
            }
        	int indexTemp = index;
        	while(index!=kBookings.size()&&kBookings.get(index)[0]<booking[1]) {
        		bookUtil(new int[] {kBookings.get(index)[0], Math.min(kBookings.get(index)[1], booking[1])},
        				bookings, level+1);
        		index++;
            }
        	if(indexTemp!=index) {
        		if(isMerged) {
        			kBookings.get(indexTemp-1)[1] = Math.max(kBookings.get(index-1)[1], booking[1]);
        			for (int i = indexTemp; i < index; i++) {
        				kBookings.remove(indexTemp);
        			}
        		}else {
        			kBookings.get(index-1)[0] = booking[0];
        			kBookings.get(index-1)[1] =  Math.max(kBookings.get(index-1)[1], booking[1]);
        			for (int i = indexTemp; i < index-1; i++) {
        				kBookings.remove(indexTemp);
        			}
        		}
        	}else {
        		if(!isMerged)
        			kBookings.add(index, booking);
        	}
    	}
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */
/*
 Implement a MyCalendarThree class to store your events. A new event can always be added.

Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

A K-booking happens when K events have some non-empty intersection (ie., there is some time that is common to all K events.)

For each call to the method MyCalendar.book, return an integer K representing the largest integer such that there exists a K-booking in the calendar.
Your class will be called like this: MyCalendarThree cal = new MyCalendarThree(); MyCalendarThree.book(start, end)

Example 1:

MyCalendarThree();
MyCalendarThree.book(10, 20); // returns 1
MyCalendarThree.book(50, 60); // returns 1
MyCalendarThree.book(10, 40); // returns 2
MyCalendarThree.book(5, 15); // returns 3
MyCalendarThree.book(5, 10); // returns 3
MyCalendarThree.book(25, 55); // returns 3
Explanation: 
The first two events can be booked and are disjoint, so the maximum K-booking is a 1-booking.
The third event [10, 40) intersects the first event, and the maximum K-booking is a 2-booking.
The remaining events cause the maximum K-booking to be only a 3-booking.
Note that the last event locally causes a 2-booking, but the answer is still 3 because
eg. [10, 20), [10, 40), and [5, 15) are still triple booked.

 

Note:

    The number of calls to MyCalendarThree.book per test case will be at most 400.
    In calls to MyCalendarThree.book(start, end), start and end are integers in the range [0, 10^9].

 */
