package leetCode.problems._905_Sort_Array_By_Parity;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        for (int i = 0,j=0,k=res.length-1; i < res.length; i++) {
			if((A[i]&1)==0)
				res[j++] = A[i];
			else 
				res[k--] = A[i];
		}
        return res;
    }
}
