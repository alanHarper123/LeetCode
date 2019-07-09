package leetCode.problems._70_Climbing_Stairs;

public class Solution {
	public int climbStairs(int n) {
		int r = n/2;
		int sum = 1;
		int sumi=1;
		for (int k = 1; k < r+1; k++) {
			long l2 = (n-k+1)*k;
			long l1;
			l1 = (n-2*k+1)*(n-2*k+2)/2;
			l1*=sumi;
			sumi = (int)(l1*2/l2);
			sum+=sumi;
		}
		return sum;
	}
	//calculate (n-k)!/(n-2*k)!/k!

	public static void main(String[] args) {
		int[]test = {
				1,2,44,5,4
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int js = test[i];
			System.out.println(solution.climbStairs(js));
		}
	}
}
