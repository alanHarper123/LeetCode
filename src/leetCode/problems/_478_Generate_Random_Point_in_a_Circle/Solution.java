package leetCode.problems._478_Generate_Random_Point_in_a_Circle;

import java.util.Random;

public class Solution {
	private Random random = new Random(System.currentTimeMillis());
	private double minX;
	private double minY;
	private double virtualBoxL;
	private double x_center;
	private double y_center;
	private double distS;
    public Solution(double radius, double x_center, double y_center) {
    	virtualBoxL = 2*radius*1.01;
    	this.x_center = x_center;
    	this.y_center = y_center;
    	minX = x_center - radius;
    	minY = y_center - radius;
    	distS = radius*radius;
    }
    
    public double[] randPoint() {
        double ranX = minX+virtualBoxL*random.nextDouble();
        double ranY = minY+virtualBoxL*random.nextDouble();
        if(valid(ranX, ranY))
        	return new double[] {ranX, ranY};
        else
        	return randPoint();
    }
    private boolean valid(double ranX, double ranY) {
    	return (ranX-x_center)*(ranX-x_center)+(ranY-y_center)*(ranY-y_center)<=distS;
    }
    public static void main(String[] args) {
		Solution solution = new Solution(1, 0, 0);
		System.out.println(solution.randPoint());
	}
}
