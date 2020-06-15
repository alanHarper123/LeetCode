package leetCode.problems._667_Beautiful_Arrangement_II;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] arrangement = new int[n];
        int i = k-1;
        int weak = 1;
        int str = k;
        while (i>=0) {
			arrangement[i--] = weak++;
			if(i>=0)
				arrangement[i--] = str--;
		}
        i=k;
        int newSeed = k+1;
        while (i<n) {
			arrangement[i++] = newSeed++;
		}
        return arrangement;
    }
}
