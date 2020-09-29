package leetCode.problems._1122_Relative_Sort_Array;

import java.util.Arrays;


public class Solution {
	private int[] indexes;
	private int[] arr1Buffer;
	public int[] relativeSortArray(int[] arr1, int[] arr2) {
		int max = -1;
		for(int e:arr2)
			max = Math.max(max, e);
		indexes = new int[max+1];
		arr1Buffer = new int[arr1.length];
		Arrays.fill(indexes, arr2.length);
		for (int i = 0; i < arr2.length; i++) {
			indexes[arr2[i]] = i;
		}
		mergeSort(arr1, 0, arr1.length);
		return arr1;
	}
	private void mergeSort(int[] arr1,int start, int end) {
		if(end-start<2)
			return;
		int mid = start+(end-start)/2;
		mergeSort(arr1, start, mid);
		mergeSort(arr1, mid, end);
		System.arraycopy(arr1, start, arr1Buffer, start, end-start);
		int i = start,j = mid,k=start;
		int vali = fetch(indexes, arr1Buffer[i]), valj = fetch(indexes, arr1Buffer[j]);
		while (i<mid&&j<end) {
			if(valj>vali||(valj==vali&&arr1Buffer[i]<arr1Buffer[j])) {
				arr1[k] = arr1Buffer[i];
				i++;
				vali = fetch(indexes, arr1Buffer[i]);
			}else {
				arr1[k] = arr1Buffer[j];
				j++;
				if(j<end)
					valj = fetch(indexes, arr1Buffer[j]);
			}
			k++;
		}
		while (i<mid) {
			arr1[k] = arr1Buffer[i];
			i++;
			k++;
		}
		while (j<end) {
			arr1[k] = arr1Buffer[j];
			j++;
			k++;
		}
	}
	private int fetch(int[] indexes,int index) {
		return index<indexes.length?indexes[index]:indexes.length;
	}
}
/*
1122. Relative Sort Array
Easy

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

 

Constraints:

    arr1.length, arr2.length <= 1000
    0 <= arr1[i], arr2[i] <= 1000
    Each arr2[i] is distinct.
    Each arr2[i] is in arr1.

*/