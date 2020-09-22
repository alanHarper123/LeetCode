package leetCode.problems._1089_Duplicate_Zeros;

public class Solution {
    public void duplicateZeros(int[] arr) {
        int dif = 0;
        int i = 0;
        for (int j = 0; i < arr.length; j++) {
			if(arr[j]==0) {
				i++;
				if(i==arr.length) {
					arr[arr.length-1] = 0;
					i = arr.length-1;
					break;
				}else 
					dif++;
			}
			i++;
		}
        i--;
        for (; dif>0; i--) {
        	int val = arr[i-dif];
        	arr[i] = val;
			if(arr[i-dif]==0) {
				arr[i-1] = 0;
				i--;
				dif--;
			}
		}
    }
}
