package leetCode.problems._731_My_Calendar_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class MyCalendarTwo {
	private ArrayList<int[]> allBookings = new ArrayList<>(1000);
	private ArrayList<int[]> doubleBookings = new ArrayList<>(1000);
	private Comparator<int[]> bookingsComparator = new Comparator<int[]>() {
		@Override
		public int compare(int[] a1, int[] a2) {
			return a1[0]-a2[0];
		}
	};
    public MyCalendarTwo() {
        
    }
    
    public boolean book(int start, int end) {
    	int[] booking = new int[] {start,end};
    	int doubleIndex = Collections.binarySearch(doubleBookings,booking,bookingsComparator);
    	if(ifTripleBooking(booking,doubleIndex))
    		return false;
    	int allBindex = Collections.binarySearch(allBookings,booking,bookingsComparator);
    	if(allBindex<0)
    		allBindex = -(allBindex+1);
    	boolean isMerged = false;
    	if(allBindex!=0&&allBookings.get(allBindex-1)[1]>start) {
        	addDoubleBooking(start, Math.min(allBookings.get(allBindex-1)[1], end));
        	allBookings.get(allBindex-1)[1] =  Math.max(allBookings.get(allBindex-1)[1], end);
        	isMerged = true;
        }
    	int allBindexTemp = allBindex;
    	while(allBindex!=allBookings.size()&&allBookings.get(allBindex)[0]<end) {
    		addDoubleBooking(allBookings.get(allBindex)[0], Math.min(allBookings.get(allBindex)[1], end));
    		allBindex++;
        }
    	if(allBindexTemp!=allBindex) {
    		if(isMerged) {
    			allBookings.get(allBindexTemp-1)[1] = Math.max(allBookings.get(allBindex-1)[1], end);
    			for (int i = allBindexTemp; i < allBindex; i++) {
    				allBookings.remove(allBindexTemp);
    			}
    		}else {
    			allBookings.get(allBindex-1)[0] = start;
    			allBookings.get(allBindex-1)[1] =  Math.max(allBookings.get(allBindex-1)[1], end);
    			for (int i = allBindexTemp; i < allBindex-1; i++) {
    				allBookings.remove(allBindexTemp);
    			}
    		}
    	}else {
    		if(!isMerged)
    			allBookings.add(allBindex, booking);
    	}
        return true;
        
    }
    private void addDoubleBooking(int start,int end) {
    	int[] booking = new int[] {start,end};
    	int doubleIndex = Collections.binarySearch(doubleBookings,booking,bookingsComparator);
    	doubleIndex = -(doubleIndex+1);
    	doubleBookings.add(doubleIndex,booking);
    }
    public boolean ifTripleBooking(int[] booking,int index) {
        if(index>=0)
        	return true;
        index = -(index+1);
        if(index!=0&&doubleBookings.get(index-1)[1]>booking[0]) {
        	return true;
        }
        if(index!=doubleBookings.size()&&doubleBookings.get(index)[0]<booking[1]) {
        	return true;
        }
        return false;
    }
    public static void main(String[] args) {
    	MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
    	int[][] data = new int[][] {{33,44},{85,95},{20,37},{91,100},{77,87},
    		{42,61},{70,82},{5,17},{16,26},{96,100},{44,55},{58,73},{60,70}};
    		for(int[]dataE:data) {
    			System.out.println(myCalendarTwo.book(dataE[0], dataE[1]));
    		}
	}
}
