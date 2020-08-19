package leetCode.problems._949_Largest_Time_for_Given_Digits;

import java.util.Arrays;

public class Solution {
	private StringBuilder res;
    public String largestTimeFromDigits(int[] A) {
    	res = new StringBuilder();
        Arrays.sort(A);
        int[] des = new int[A.length];
        boolean[] isLocked = new boolean[A.length];
        backTrack(A, isLocked, 0, des);
        return res.toString();
    }
    private void backTrack(int[] A,boolean[] isLocked,int i, int[] des) {
    	if(i==des.length) {
    		res.append(des[0]);
    		res.append(des[1]);
    		res.append(':');
    		res.append(des[2]);
    		res.append(des[3]);
    		return;
    	}
    	int max;
    	switch (i) {
		case 0:
			max = 2;
			break;
		case 1:
			if(des[0]==2)
				max=3;
			else 
				max=9;
			break;
		case 2:
			max = 5;
			break;
		default:
			max = 9;
			break;
		}
    	for (int j = A.length-1; j >=0; j--) {
			if(A[j]<=max&&!isLocked[j]) {
				des[i] = A[j];
				isLocked[j] = true;
				backTrack(A, isLocked, i+1, des);
				if(res.length()!=0)
					return;
				isLocked[j] = false;
			}
		}
    }
}
