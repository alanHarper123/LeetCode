package leetCode.problems._598_Range_Addition_II;

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minR = m;
        int minCol = n;
        for(int[] op:ops) {
        	if(op[0]<minR)
        		minR = op[0];
        	if(op[1]<minCol)
        		minCol = op[1];
        }
        return minR*minCol;
    }
}
