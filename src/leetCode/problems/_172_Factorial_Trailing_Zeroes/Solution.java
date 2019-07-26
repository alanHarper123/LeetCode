package leetCode.problems._172_Factorial_Trailing_Zeroes;

public class Solution {
	
    public int trailingZeroes(int n) {
    	int result = 0;
    	while (n>0) {
			n/=5;
			result+=n;
		}
    	return result;
    }
    private long factorial(int n) {
    	if(n==0)
    		return 1;
    	if(n<0)
    		return -1;
    	long result=1;
    	for (int i = 1; i <= n; i++) {
			result*=i;
		}
    	return result;
    }
    public static void main(String[] args) {
    	int[] testData = {15,30};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(solution.factorial(testData[i]));
			System.out.println(solution.trailingZeroes(testData[i]));
			
		}
	}
}
