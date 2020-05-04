package leetCode.problems._461_Hamming_Distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}
