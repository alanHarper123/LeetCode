package leetCode.problems._Angle_Between_Hands_of_a_Clock;

public class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = (double)minutes/60;
        double hourAngle = (double)hour/12+minuteAngle/12;
        double res = Math.abs(minuteAngle-hourAngle);
        res*=360;
        if(res>180)
        	res = 360-res;
        return res;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.angleClock(12, 30));
	}
}
