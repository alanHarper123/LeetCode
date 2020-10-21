package leetCode.problems._1201_Ugly_Number_III;

import java.util.ArrayList;
public class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        if(a>b) {
        	int temp = a;
        	a = b;
        	b = temp;
        }
        if(a>c) {
        	int temp = a;
        	a = c;
        	c = temp;
        }
        long start = a, end =  n*a;
        long a_c = (long)a*c/gcd(a, c);
        long a_b = (long)a*b/gcd(a, b);
        long b_c = (long)b*c/gcd(b, c);
        long a_b_c = (long)c*(a_b/gcd(c,a_b));
        while (end>=start) {
			long mid = start+(end-start)/2;
			long countA = mid/a;
			long countB  = mid/b;
			long countC = mid/c;
			long sum = countA+countB+countC;
			sum-=mid/a_c;
			sum-=mid/a_b;
			sum-=mid/b_c;
			sum+=mid/a_b_c;
			if(n>sum)
				start = mid+1;
			else if(n<sum)
				end = mid;
			else 
				return (int) Math.max(countA*a, Math.max(countB*b, countC*c));
				
		}
        return 0;
    }
    private long gcd(long a, long b) {
    	if(a<b)
    		return gcd(b, a);
    	long r = a%b;
    	if(r==0)
    		return b;
    	return gcd(r, b);
    }
    public static void main(String[] args) {
    	System.out.println(System.currentTimeMillis());
		System.out.println(new Solution().nthUglyNumber(1000000000, 2, 217983653, 336916467));
		System.out.println(System.currentTimeMillis());
	}
    public int nthUglyNumber001(int n, int a, int b, int c) {
        if(a>b) {
        	int temp = a;
        	a = b;
        	b = temp;
        }
        if(a>c) {
        	int temp = a;
        	a = c;
        	c = temp;
        }
        if(b>c) {
        	int temp = b;
        	b = c;
        	c = temp;
        }
        int na = n*a;
        int start = a, end = na%a==n?na:Integer.MAX_VALUE;
        int a_c = getCommonCombine(a, c);
        int a_b = getCommonCombine(a, b);
        System.out.println(System.currentTimeMillis());
        int b_c = getCommonCombine(b, c);
        int a_b_c = getCommonCombine(a_c, a_b);
        System.out.println(System.currentTimeMillis());
        boolean isACoverFlow = a_c%a!=0||a_c%c!=0;
        boolean isABoverFlow = a_b%a!=0||a_b%b!=0;
        boolean isBCoverFlow = b_c%b!=0||b_c%c!=0;
        boolean isABCoverFlow = a_b_c%a!=0||a_b_c%b!=0||a_b_c%c!=0;
    	System.out.println(System.currentTimeMillis());
        while (end>=start) {
			int mid = start+(end-start)/2;
			int countA = mid/a;
			int countB  = mid/b;
			int countC = mid/c;
			int sum = countA+countB+countC;
			if(!isACoverFlow&&mid>=a_c)
				sum-=mid/a_c;
			if(!isABoverFlow&&mid>=a_b)
				sum-=mid/a_b;
			if(!isBCoverFlow&&mid>=b_c)
				sum-=mid/b_c;
			if(!isABCoverFlow&&mid>=a_b_c)
				sum+=mid/a_b_c;
			if(n>sum)
				start = mid+1;
			else if(n<sum)
				end = mid;
			else {
				return Math.max(countA*a, Math.max(countB*b, countC*c));
			}	
		}
        return 0;
    }

    private int getCommonCombine(int a, int b) {
        ArrayList<Integer> primesAD = new ArrayList<>();
        getPrimes(a, primesAD);
        ArrayList<Integer> primesBD = new ArrayList<>();
        getPrimes(b, primesBD);
        return getCommon(primesAD, primesBD);
    }
    private void getPrimes(int a, ArrayList<Integer> primesAD) {
    	if(a%2==0) {
			int count = 1;
			a/=2;
			while (a%2==0) {
				count++;
				a/=2;
			}
			primesAD.add(2);
			primesAD.add(count);
		}
    	for (int i = 3; a!=1; i+=2) {
    		if(a%i==0) {
				int count = 1;
				a/=i;
				while (a%i==0) {
					count++;
					a/=i;
				}
				primesAD.add(i);
				primesAD.add(count);
			}
		}
    }
    private int getCommon(ArrayList<Integer> p1,ArrayList<Integer> p2){
    	int pi1 = 0, pi2 = 0;
    	int res = 1;
    	while (pi1<p1.size()&&pi2<p2.size()) {
			if(p1.get(pi1)>p2.get(pi2)) {
				res*=(int)Math.pow(p2.get(pi2), p2.get(pi2+1));
				pi2+=2;
			}else if(p1.get(pi1)<p2.get(pi2)) {
				res*=(int)Math.pow(p1.get(pi1), p1.get(pi1+1));
				pi1+=2;
			}else {
				
				int count = Math.max(p1.get(pi1+1), p2.get(pi2+1));
				res*=(int)Math.pow(p1.get(pi1), count);
				pi1+=2;
				pi2+=2;
			}
		}
    	while (pi1<p1.size()){
			res*=(int)Math.pow(p1.get(pi1), p1.get(pi1+1));
			pi1+=2;
    	}
    	while (pi2<p2.size()) {
			res*=(int)Math.pow(p2.get(pi2), p2.get(pi2+1));
			pi2+=2;
		}
    	return res;
    }
}
