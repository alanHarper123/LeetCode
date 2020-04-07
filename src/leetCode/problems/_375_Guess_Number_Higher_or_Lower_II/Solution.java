package leetCode.problems._375_Guess_Number_Higher_or_Lower_II;

public class Solution {
	private int[][] base;
    public int getMoneyAmount(int n) {
        base = new int[n][n];
        getMoneyAmountUtil();
        return base[0][n-1];
    }
    private void getMoneyAmountUtil() {
    	int min;
    	for (int i = 1; i < base.length; i++) {
			for (int j = 0; j < base.length-i; j++) {
				min = Integer.MAX_VALUE;
				for (int l = j; l <= j+i; l++) {
					int temp;
					temp=Math.max(l-1>j?base[j][l-1]:0,
							j+i>l+1?base[l+1][j+i]:0) +l+1;
					if(temp<min)
						min=temp;
				}
				base[j][j+i]=min;
			}
		}
    }
    public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getMoneyAmount(4));
	}
}
