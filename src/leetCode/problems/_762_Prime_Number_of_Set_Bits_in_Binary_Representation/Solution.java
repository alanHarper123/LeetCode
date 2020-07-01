package leetCode.problems._762_Prime_Number_of_Set_Bits_in_Binary_Representation;

import java.util.HashSet;

public class Solution {
    public int countPrimeSetBits(int L, int R) {
        boolean[] bits = new boolean[Integer.BYTES*8];
        int runner = L;
        int index = 0;
        while (runner!=0) {
			bits[index++] = (runner&1)==1;
			runner>>=1;
		}
        int bitsCount = Integer.bitCount(L);
        HashSet<Integer> primes = new HashSet<>();
        for (int i = 1; i <= bits.length; i++) {
			if(isPrime(i))
				primes.add(i);
		}
        int count = 0;
        for (int i = L; i <= R; i++) {
			if(primes.contains(bitsCount))
				count++;
			for (int j = 0; j < bits.length; j++) {
				if(bits[j])
					bits[j] = false;
				else {
					bitsCount+=1-j;
					bits[j] = true;
					break;
				}
			}
		}
        return count;
    }
    private boolean isPrime(int n) {
    	if(n<2)
    		return false;
    	int root = (int) Math.sqrt(n);
    	for (int i = 2; i <= root; i++) {
			if(n%i==0)
				return false;
		}
    	return true;
    }
}
