package leetCode.problems._717_1_bit_and_2_bit_Characters;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = bits.length-2;
        boolean isOneBit = true;
        while (i>=0&&bits[i]!=0) {
			i--;
			isOneBit = !isOneBit;
		}
        return isOneBit;
    }
}
