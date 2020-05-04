package leetCode.problems._Number_Complement;

public class Solution {
    public int findComplement(int num) {
        int k=1;
        int mask = 0;
        int bitC = 8*Integer.BYTES-1;
        while (bitC>0&&k<=num) {
        	bitC--;
			mask+=k;
			k<<=1;
		}
        return num^mask;
    }
}
