package leetCode.problems._1109_Corporate_Flight_Bookings;

import java.util.Arrays;

public class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int[][] endFlights = new int[bookings.length][2];
        for (int i = 0; i < endFlights.length; i++) {
			endFlights[i][0] = bookings[i][1];
			endFlights[i][1] = bookings[i][2];
		}
        Arrays.sort(bookings,(a1,a2)->a1[0]-a2[0]);
        Arrays.sort(endFlights,(a1,a2)->a1[0]-a2[0]);
        int seat_Num = 0;
        int flighti = 0;
        int k = 0;
        for (int i = 0, next_start; i < bookings.length; i++) {
        	next_start = bookings[i][0];
        	while (endFlights[k][0]<next_start) {
				for (; flighti < endFlights[k][0]; flighti++) {
					res[flighti] = seat_Num;
				}
				seat_Num -= endFlights[k][1];
				k++;
			}
        	if((endFlights[k][0]==next_start)) {
        		for (; flighti < next_start; flighti++) {
					res[flighti] = seat_Num;
				}
        		res[next_start-1] +=bookings[i][2];
        	}
        	for (; flighti < next_start-1; flighti++) {
				res[flighti] = seat_Num;
			}
        	seat_Num+=bookings[i][2];
		}
        while (k<endFlights.length) {
			for (; flighti < endFlights[k][0]; flighti++) {
				res[flighti] = seat_Num;
			}
			seat_Num -= endFlights[k][1];
			k++;
		}
        return res;
    }
    public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][] {{1,2,10},{2,3,20},{2,5,25}}, 5)));
		System.out.println(Arrays.toString(new Solution().corpFlightBookings(new int[][] {{2,2,35},{1,2,10}}, 2)));
	}
}
