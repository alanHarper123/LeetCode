package leetCode.problems._556_Next_Greater_Element_III;

import java.util.LinkedList;

public class Solution {
    public int nextGreaterElement(int n) {
        int count = 1;
        int result = 0;
        int cur;
        LinkedList<Integer> reverseNums = new LinkedList<>();
        while (n>0) {
			cur = n%10;
			n/=10;
			if(reverseNums.size()!=0) {
				if(cur<reverseNums.peekLast()) {
					int k=1;
					int reversN=reverseNums.peekFirst();
					boolean isReversed = false;
					while (!reverseNums.isEmpty()) {
						int num = reverseNums.pollLast();
						if(isReversed==false&&cur>=num) {
							isReversed=true;
							k/=10;
							reversN=result/k;
							result-=reversN*k;
							result+=cur*k;
							k*=10;
						}
						result+=k*num;
						k*=10;
					}
					if(isReversed==false) {
						k/=10;
						result-=(result/k)*k;
						result+=cur*k;
					}
					n*=10;
					n+=reversN;
					int nPre = n;
					n*=count;
					if(n/count!=nPre)
						return -1;
					result+=n;
					if(result<0)
						return -1;
					else 
						return result;
				}
			}
			reverseNums.add(cur);
			count*=10;
		}
        return -1;
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.nextGreaterElement(1999999999));
	}
}
