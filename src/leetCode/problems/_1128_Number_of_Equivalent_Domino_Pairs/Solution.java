package leetCode.problems._1128_Number_of_Equivalent_Domino_Pairs;

public class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[][] counts = new int[10][10];
        int ci,cj;
        for(int[] domino:dominoes) {
        	if(domino[0]<domino[1]) {
        		ci = domino[0];
        		cj = domino[1];
        	}else {
        		cj = domino[0];
        		ci = domino[1];
        	}
        	counts[ci][cj]++;	
        }
        int sum = 0;
        for (int i = 0,count; i < 10; i++) {
			for (int j = i; j < 10; j++) {
				count = counts[i][j];
				if(count>1) {
					sum+=(count*(count-1))/2;
				}
			}
		}
        return sum;
    }
}
/*
1128. Number of Equivalent Domino Pairs
Easy

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1

 

Constraints:

    1 <= dominoes.length <= 40000
    1 <= dominoes[i][j] <= 9
*/