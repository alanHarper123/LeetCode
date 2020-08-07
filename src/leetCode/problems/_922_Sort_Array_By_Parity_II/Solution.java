package leetCode.problems._922_Sort_Array_By_Parity_II;

public class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int evenEnd = A.length-2;
        int oddEnd = A.length-1;
        int temp;
        int start = 0;
        while (evenEnd>=0||oddEnd>0) {
        	if(evenEnd<0)
        		start = 1;
			if((A[start]&1)==1) {
				temp = A[start];
				A[start] = A[oddEnd];
				A[oddEnd] = temp;
				oddEnd-=2;
			}else {
				temp = A[start];
				A[start] = A[evenEnd];
				A[evenEnd] = temp;
				evenEnd-=2;
			}
		}
        return A;
    }
}
