package leetCode.problems._930_Binary_Subarrays_With_Sum;

public class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
    	if(S==0) {
    		int len = 0,sum = 0;
    		for (int i = 0; i < A.length; i++) {
				if(A[i]==1) {
					if(len!=0) {
						sum+=(len*(len+1))/2;
						len=0;
					}
				}else {
					len++;
				}	
			}
    		if(len!=0) {
				sum+=(len*(len+1))/2;
				len=0;
			}
    		return sum;
    	}
        int left=0,right=0,count=0,sum=0,leftZC,rightZC;
        for (; right < A.length; right++) {
        	if(A[right]==1) {
        		count++;
    			if(count==S) {
    				rightZC = right;
    				while (right+1<A.length&&A[right+1]==0) {
    					right++;
    				}
    				rightZC = right-rightZC+1;
    				leftZC = left;
    				while (left<right&&A[left]==0) {
    					left++;
    				}
    				leftZC = left-leftZC+1;
    				sum+=leftZC*rightZC;
    				left++;
    				while (A[left]==0) {
						left++;
					}
    				count--;
    			}
        	}
		}
        return sum;
    }
}
/*
930. Binary Subarrays With Sum
Medium

In an array A of 0s and 1s, how many non-empty subarrays have sum S?

 

Example 1:

Input: A = [1,0,1,0,1], S = 2
Output: 4
Explanation: 
The 4 subarrays are bolded below:
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]
[1,0,1,0,1]

 

Note:

    A.length <= 30000
    0 <= S <= A.length
    A[i] is either 0 or 1.
 */