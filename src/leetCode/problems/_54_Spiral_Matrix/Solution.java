package leetCode.problems._54_Spiral_Matrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> resultList = new ArrayList<>();
		if(matrix.length==0) {
			return resultList;
		}
		int r1 = matrix.length;
		int r2 = matrix[0].length;
		int roundsN = Math.min(r1/2, r2/2);
		if(r1%2!=0||r2%2!=0) {
			roundsN++;
		}
		for (int i = 0; i < roundsN; i++) {

			for(int j=i;j<r2-1-i;j++) {
				resultList.add(matrix[i][j]);
			}
			for (int k = i; k <r1-1-i; k++) {
				resultList.add(matrix[k][r2-1-i]);
			}
			if(2*i>r1-1||2*i>r2-1) {
				if(r1==0) {
					resultList.add(matrix[0][r2-1]);
				}
				if (r2==0) {
					resultList.add(matrix[r1-1][0]);
				}
			}else if(2*i==r1-1) {
				resultList.add(matrix[i][r2-r1+i]);
				break;
			}else if (2*i==r2-1) {                   
				resultList.add(matrix[r1-r2+i][i]);
				break;
			}

			for (int l = r2-1-i; l > i; l--) {
				resultList.add(matrix[r1-1-i][l]);

			}

			for (int m = r1-1-i; m > i; m--) {
				resultList.add(matrix[m][i]);

			}
		}
		return resultList;
	}
	public static void main(String[] args) {
		int[][] test1 = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int[][] test2 = {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12}
		};
		int[][] test3 = {
				{1,2},
				{5,6},
				{9,10}
		};
		int[][] test4 = {
				{1},
				{5},
				{9}
		};
		int[][] test5 = {
				{1,2,3}
		};
		System.out.println(new Solution().spiralOrder(test1));
		System.out.println(new Solution().spiralOrder(test2));
		System.out.println(new Solution().spiralOrder(test3));
		System.out.println(new Solution().spiralOrder(test4));
		System.out.println(new Solution().spiralOrder(test5));
	}
}
