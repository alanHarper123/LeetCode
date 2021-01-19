package leetCode.problems._1227_Airplane_Seat_Assignment_Probability;

import java.util.ArrayList;

public class Solution {
	static private ArrayList<Double> dp = new ArrayList<>();
	static private ArrayList<Double> dpSum = new ArrayList<>();
	static {
		dp.add(1.0);
		dpSum.add(1.0);
	}
    public double nthPersonGetsNthSeat001(int n) {
        if(n<dp.size())
        	return dp.get(n-1);
        int s = dp.size()+1;
        double p = 0;
        while (n>=s) {
        	p=(1/(double)s)*(dpSum.get(s-2));
        	dp.add(p);
        	dpSum.add(p+dpSum.get(s-2));
			s++;
		}
        return dp.get(n-1);
    }
    public double nthPersonGetsNthSeat(int n) {
        if(n==1)
        	return 1;
        else {
			return 0.5;
		}
    }
}
