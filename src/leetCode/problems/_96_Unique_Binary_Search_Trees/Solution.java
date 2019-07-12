package leetCode.problems._96_Unique_Binary_Search_Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public int numTrees(int n) {
		ArrayList<Integer> resultList = new ArrayList<>(
				Arrays.asList(1,1,2,5,14));
		if(n<1)
			return 0;
		if(n<5)
			return resultList.get(n);
		for (int i = 5; i <= n; i++) {
			int k=0;
			for (int j = 0; 2*j < i; j++) {
				int multiply = 2;
				if(j==resultList.size()-1-j)
					multiply=1;
				k+=multiply*resultList.get(j)*
						resultList.get(resultList.size()-1-j);
			}
			resultList.add(k);
		}
		return resultList.get(resultList.size()-1);
	}
	public static void main(String[] args) {
		int[] test = {5,6,7,8};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			System.out.println(solution.numTrees(test[i]));
		}

	}
}
