package leetCode.problems._933_Number_of_Recent_Calls;

import java.util.LinkedList;

public class RecentCounter {
	private LinkedList<Integer> pings = new LinkedList<>();
    public RecentCounter() {
    }
    
    public int ping(int t) {
        pings.add(t);
        int lowLimit = t-3000;
        while (pings.peekFirst()<lowLimit) {
			pings.pollFirst();
		}
        return pings.size();
    }
}
