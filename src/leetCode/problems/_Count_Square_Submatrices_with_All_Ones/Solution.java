package leetCode.problems._Count_Square_Submatrices_with_All_Ones;

public class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix==null||matrix.length==0)
        	return 0;
        int[][] dp = new int[2][matrix[0].length+1];
        int squareCount = 0;
        int k = 1;
        int preK = 0;
        for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if(matrix[i][j]==1) {
					dp[k][j+1] = Math.min(Math.min(dp[k][j], dp[preK][j]), dp[preK][j+1])+1;
					squareCount+=dp[k][j+1];
				}else {
					dp[k][j+1]=0;
				}
			}
			preK=k;
			k=1-k;
		}
        return squareCount;
    }
    public static void main(String[] args) {
		int[][] text = new int[][] {{0,1,1,1},{1,1,0,1},{1,1,1,1},{1,0,1,0}};
		Solution solution = new Solution();
		System.out.println(solution.countSquares(text));
	}
}
