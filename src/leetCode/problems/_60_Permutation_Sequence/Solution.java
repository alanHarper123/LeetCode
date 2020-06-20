package leetCode.problems._60_Permutation_Sequence;

import java.util.ArrayList;
public class Solution {
	public String getPermutation(int n, int k) {
		int[] indexes = new int[n+1];
		indexes[0]=1;
		indexes[1]=1;
		for (int i = 2; i < indexes.length; i++) {
			indexes[i]=indexes[i-1]*i;
		}
		char[] resultTempList = new char[n];
		ArrayList<Integer> baseList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			baseList.add(i+1);
		}
		int kKeep = 0;
		for (int i = 0; i < n; i++) {
			int subtrack = kKeep*(n-i);
			int main = k/indexes[n-1-i];
			if( k%indexes[n-1-i]==0&&main!=0) {
				main--;
			}
			int ktemp = main-subtrack;
			kKeep = main;
			resultTempList[i]=(char)('0'+baseList.remove(ktemp));
		}
		return new String(resultTempList);
	}
	public static void main(String[] args) {
		int[][] test = {
				{3,2},
				{4,9},
				{3,3},
		};
		Solution solution = new Solution();
		leetCode.problems._47_Permutations_II.Solution solution2 = 
				new leetCode.problems._47_Permutations_II.Solution();
		for (int i = 0; i < test.length; i++) {
			int[] baseList = new int[test[i][0]];
			for (int j = 0; j < test[i][0]; j++) {
				baseList[j] = j+1;
			}
			System.out.println(test[i][0]+"  "+test[i][1]);
			System.out.println(solution.getPermutation(test[i][0], test[i][1]));
			System.out.println(solution2.permuteUnique(baseList));
		}

	}
}
class Solution002 {
	public String getPermutation(int n, int k) {
		int[] indexes = new int[n+1];
		indexes[0]=1;
		indexes[1]=1;
		for (int i = 2; i < indexes.length; i++) {
			indexes[i]=indexes[i-1]*i;
		}
		char[] resultTempList = new char[n];
		ArrayList<Integer> baseList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			baseList.add(i+1);
		}
		for (int i = 0; i < n; i++) {
			int  index = k/indexes[n-1-i];
			if( k%indexes[n-1-i]==0&&index!=0) {
				index--;
			}
			k-=index*indexes[n-1-i];
			resultTempList[i]=(char)('0'+baseList.remove(index));
		}
		return new String(resultTempList);
	}
}
