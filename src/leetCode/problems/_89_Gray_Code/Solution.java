package leetCode.problems._89_Gray_Code;

import java.util.ArrayList;
import java.util.List;

class Solution {

	public List<Integer> grayCode(int n) {
		ArrayList<Integer> result = new ArrayList<>((int)Math.pow(2, n));
		result.add(0);
		if (n<=0) 
			return result;
		for (int i = 0; i < n; i++) {
			int count = result.size();
			for (int j = count-1; j >= 0; j--) {
				result.add(result.get(j)+(1<<i));
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[][]test = {
				{2,3},
				{3,2},
				{4},
		};
		Solution solution = new Solution();
		for (int i = 0; i < test.length; i++) {
			int[] js = test[i];	
			System.out.println(solution.grayCode(js[0]));
			System.out.println("+++++++++++++++++");
		}
	}
}
