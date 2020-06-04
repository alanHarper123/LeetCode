package leetCode.problems._633_Sum_of_Square_Numbers;

public class Solution {
    public boolean judgeSquareSum(int c) {
    	if(isSquareNumber(c))
    		return true;
        int maxASquare = c/2;
        int aSquare = 0;
        for (int i = 1;aSquare<=maxASquare; i+=2) {
			aSquare+=i;
			if(isSquareNumber(c-aSquare))
				return true;
		}
        return false;
    }
    private boolean isSquareNumber(int judgee){
    	int root = (int)Math.sqrt(judgee);
    	return root*root==judgee;
    }
}
