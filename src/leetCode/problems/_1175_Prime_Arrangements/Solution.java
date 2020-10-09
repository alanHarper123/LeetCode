package leetCode.problems._1175_Prime_Arrangements;

public class Solution {
	int mod = 1000000000+7;
    public int numPrimeArrangements(int n) {
    	if(n<3)
    		return 1;
    	int primeN = 1;
        for (int i = 3; i <= n; i+=2) {
			if(isPrime(i))
				primeN++;
		}
        return (int) ((factorial(primeN)*factorial(n-primeN))%mod);
    }
    private long factorial(long n) {
    	if(n==1)
    		return 1;
    	return (n*factorial(n-1))%mod;
    }
    private boolean isPrime(int n) {
    	int root = (int) Math.sqrt(n);
    	for (int i = 2; i <= root; i++) {
			if(n%i==0)
				return false;
		}
    	return true;
    }
}
