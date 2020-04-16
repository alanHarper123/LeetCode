package leetCode.problems._400_Nth_Digit;

public class Solution {
    public int findNthDigit(int n) {
        int digitCount = 1;
        int digitRange = 9;
        // to avoid digitRange*digitCount overflow;
        while((n/digitCount+(n%digitCount==0?0:1))>digitRange){
        	n-=digitRange*digitCount;
        	digitCount++;
        	digitRange = 10*digitRange;
        }
        int m = n/digitCount-1; int k = n%digitCount;
        if(k>0) {
        	m++;
        	k=digitCount-k;
        }	
        m=(int)Math.pow(10, digitCount-1)+m;
        
        m/=(int)Math.pow(10, k);
        return m%10;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findNthDigit(1000000000));
	}
}
