package leetCode.problems._509_Fibonacci_Number;

public class Solution {
	private static double sqrt_5 = Math.sqrt(5);
	private static double alpha1 = (1+sqrt_5)/2;
	private static double alpha2 = (1-sqrt_5)/2;
    public int fib(int N) {
        return (int)(1/sqrt_5*(Math.pow(alpha1, N)-Math.pow(alpha2, N)));
    }
}
