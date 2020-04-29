package leetCode.problems._441_Arranging_Coins;

public class Solution {
    public int arrangeCoins(int n) {
        return (int)(Math.sqrt(2*(double)n+0.25)-0.5);
    }
}
