package leetCode.problems._201_Bitwise_AND_of_Numbers_Range;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int delta = n-m;
        int k=1;
        int result=0;
        while (m!=0) {
        	if((m&k)!=0) {
        		if(delta<k) {
        			result+=k;
        		}
            	delta+=k;
            	m-=k;
        	}
        	k=k<<1;
		}
        return result;
    }
    public static void main(String[] args) {
		int[][] testData = {
			{5,7},
			{0,1},
		};
		Solution solution = new Solution();
		for (int i = 0; i < testData.length; i++) {
			System.out.println(solution.
					rangeBitwiseAnd(testData[i][0], testData[i][1]));
		}
	}
}
