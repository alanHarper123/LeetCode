package leetCode.problems._870_Advantage_Shuffle;

import java.util.Arrays;

public class Solution {
	public int[] advantageCount(int[] A, int[] B) {
		int[] b_index = new int[B.length];
		for (int i = 0; i < b_index.length; i++) {
			b_index[i] = i;
		}
		Arrays.sort(A);
		sortArr1(B, b_index, 0, B.length);
		int[] res = new int[A.length];
		Arrays.fill(res, -1);
		int i = A.length-1;
		int j = B.length-1;
		loop1:for (; i>=0; i--) {
			for (; j >=0; j--) {
				if(A[i]>B[j]) {
					res[b_index[j]] = A[i];
					j--;
					continue loop1;
				}	
			}
			break;
		}

		for (int k = 0; i>=0&&k<res.length; k++) {
			if(res[k]==-1)
				res[k] = A[i--];
		}
		return res;
	}
	//sort arr1, and change arr2 accordingly.
	public static void sortArr1(int[] arr1, int[] arr2,int start,int end) {
		if(end-start<=1)
			return;
		int mid = (end+start)/2;
		sortArr1(arr1, arr2, start, mid);
		sortArr1(arr1, arr2, mid, end);
		int[] dif1 = Arrays.copyOfRange(arr1, start, mid);
		int[] pfoF1 = Arrays.copyOfRange(arr2, start, mid);
		int[] dif2 = Arrays.copyOfRange(arr1, mid, end);
		int[] pfoF2 = Arrays.copyOfRange(arr2, mid, end);
		int d1 = 0, d2 = 0;
		while (d1<dif1.length&&d2<dif2.length) {
			if(dif1[d1]>dif2[d2]) {
				arr1[start] = dif2[d2];
				arr2[start++] = pfoF2[d2++];
			}else {
				arr1[start] = dif1[d1];
				arr2[start++] = pfoF1[d1++];
			}
		}
		while (d1<dif1.length) {
			arr1[start] = dif1[d1];
			arr2[start++] = pfoF1[d1++];
		}
		while (d2<dif2.length) {
			arr1[start] = dif2[d2];
			arr2[start++] = pfoF2[d2++];
		}
	}
}
