package leetCode.problems._985_Sum_of_Even_Numbers_After_Queries;

public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] res = new int[queries.length];
        int i = 0,j,val;
        for (; i < A.length; i++) {
			val = A[i];
			if((val&1)==0) 
				sum+=val;
		}
        i = 0;
        for (int[] querie:queries) {
			j = querie[1];
			val = A[j];
			if((val&1)==0) 
				sum-=val;
			val+=querie[0];
			if((val&1)==0) 
				sum+=val;
			A[j] = val;
			res[i++] = sum;
		}
        return res;
    }
}
