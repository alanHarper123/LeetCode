package leetCode.problems._1072_Flip_Columns_For_Maximum_Number_of_Equal_Rows;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
    	HashMap<String, Integer> map = new HashMap<>();
        for(int[] row:matrix) {
        	StringBuilder orig = new StringBuilder();
        	StringBuilder rev = new StringBuilder();
        	for (int e:row) {
				orig.append(e);
				rev.append(1-e);
			}
        	String os = orig.toString();
        	String rs = rev.toString();
        	map.put(os, map.getOrDefault(os, 0)+1);
        	map.put(rs, map.getOrDefault(rs, 0)+1);
        }
        int max = 0;
        for(int count:map.values()) {
        	if(count>max)
        		max = count;
        }
        return max;
    }
}
/*
1072. Flip Columns For Maximum Number of Equal Rows
Medium

Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.

Return the maximum number of rows that have all values equal after some number of flips.

 

Example 1:

Input: [[0,1],[1,1]]
Output: 1
Explanation: After flipping no values, 1 row has all values equal.

Example 2:

Input: [[0,1],[1,0]]
Output: 2
Explanation: After flipping values in the first column, both rows have equal values.

Example 3:

Input: [[0,0,0],[0,0,1],[1,1,0]]
Output: 2
Explanation: After flipping values in the first two columns, the last two rows have equal values.

 

Note:

    1 <= matrix.length <= 300
    1 <= matrix[i].length <= 300
    All matrix[i].length's are equal
    matrix[i][j] is 0 or 1

*/