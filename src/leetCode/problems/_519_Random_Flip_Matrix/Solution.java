package leetCode.problems._519_Random_Flip_Matrix;

import java.util.HashSet;
import java.util.Random;

public class Solution {
	private Random rand = new Random(System.currentTimeMillis());
	private int n_cols;
	private int totalC;
	private HashSet<Integer> visitedIndexs;
	public Solution(int n_rows, int n_cols) {
		this.n_cols = n_cols;
		visitedIndexs = new HashSet<>();
		totalC = n_cols*n_rows;
	}

	public int[] flip() {
		int random;
		do {
			random=rand.nextInt(totalC);
		} while (visitedIndexs.contains(random));
		visitedIndexs.add(random);

		return new int[] {random/n_cols,random%n_cols};
	}

	public void reset() {
		visitedIndexs.clear();
	}
}
