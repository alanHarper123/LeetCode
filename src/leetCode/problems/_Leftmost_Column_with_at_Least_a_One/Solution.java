package leetCode.problems._Leftmost_Column_with_at_Least_a_One;

import java.util.List;

// This is the BinaryMatrix's API interface.
 // You should not implement it, or speculate about its implementation
  interface BinaryMatrix {
      public int get(int x, int y);
      public List<Integer> dimensions();
 };


public class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimensions = binaryMatrix.dimensions();
        int row = dimensions.get(0);
        int col = dimensions.get(1);
        int ans = col-1;
        for (int i = 0; ans>=0 && i<row; i++) {
			while (ans>=0&&binaryMatrix.get(i, ans)==1) {
				ans--;
			}
		}
        if(ans==col-1)
        	return -1;
		return ans+1;
    }
}
