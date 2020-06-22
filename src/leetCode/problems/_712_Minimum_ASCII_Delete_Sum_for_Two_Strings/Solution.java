package leetCode.problems._712_Minimum_ASCII_Delete_Sum_for_Two_Strings;

public class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int row = s1.length()+1;
        int col = s2.length()+1;
        int[][] minimumSums = new int[row][col];
        for (int i = 1; i < row; i++) {
			minimumSums[i][0] = s1.charAt(i-1)+minimumSums[i-1][0];
		}
        for (int i = 1; i < col; i++) {
			minimumSums[0][i] = s2.charAt(i-1)+minimumSums[0][i-1];
		}
        for (int i = 1; i < row; i++) {
        	for (int j = 1; j < col; j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					minimumSums[i][j]=Math.min(minimumSums[i-1][j-1],
							Math.min(minimumSums[i][j-1]+s2.charAt(j-1),
									minimumSums[i-1][j]+s1.charAt(i-1)));
				}else {
					minimumSums[i][j]=Math.min(minimumSums[i][j-1]+s2.charAt(j-1),
							minimumSums[i-1][j]+s1.charAt(i-1));
				}
			}
		}
        return minimumSums[row-1][col-1];
    }
}
